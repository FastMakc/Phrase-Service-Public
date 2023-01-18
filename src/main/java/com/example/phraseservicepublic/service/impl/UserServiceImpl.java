package com.example.phraseservicepublic.service.impl;

import com.example.phraseservicepublic.dao.UserDao;
import com.example.phraseservicepublic.domain.api.user.getMyPhrases.GetMyPhrasesResp;
import com.example.phraseservicepublic.domain.api.user.getMyPhrases.PhraseResp;
import com.example.phraseservicepublic.domain.api.user.login.LoginReq;
import com.example.phraseservicepublic.domain.api.user.login.LoginResp;
import com.example.phraseservicepublic.domain.api.user.publicPhrases.PublicPhraseReq;
import com.example.phraseservicepublic.domain.api.user.registration.RegistrationReq;
import com.example.phraseservicepublic.domain.api.user.registration.RegistrationResp;
import com.example.phraseservicepublic.domain.constant.Code;
import com.example.phraseservicepublic.domain.dto.User;
import com.example.phraseservicepublic.domain.entity.Phrase;
import com.example.phraseservicepublic.domain.response.Response;
import com.example.phraseservicepublic.domain.response.SuccessResponse;
import com.example.phraseservicepublic.domain.response.exception.CommonException;
import com.example.phraseservicepublic.service.UserService;
import com.example.phraseservicepublic.util.EncryptUtils;
import com.example.phraseservicepublic.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final ValidationUtils validationUtils;
    private final EncryptUtils encryptUtils;
    private final UserDao userDao;

    @Override
    public ResponseEntity<Response> getMyPhrases(long accessToken) {

        long userId = userDao.getUserIdByPhraseId(accessToken);
        List<Phrase> phraseList = userDao.getPhrasesByUserId(userId);

        List<PhraseResp> phrasesRespList = new ArrayList<>();
        for (Phrase phrase : phraseList) {
            List<String> tags = userDao.getTagsByPhraseId(phrase.getId());
            phrasesRespList.add(PhraseResp.builder()
                    .id(phrase.getId())
                    .text(phrase.getText())
                    .timeInsert(phrase.getTimeInsert())
                    .tags(tags).build());
        }
        return new ResponseEntity<>(SuccessResponse.builder().data(GetMyPhrasesResp.builder().phrases(phrasesRespList).build()).build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken) {
        validationUtils.validationRequest(req);

        long userId = userDao.getIdByToken(accessToken);
        long phraseId = userDao.addPhrase(userId, req.getText());
        log.info("userId: {}, phraseId: {}", userId, phraseId);

        for (String tag : req.getTags()) {
            userDao.addTag(tag);
            userDao.addPhraseTag(phraseId, tag);
        }

        return new ResponseEntity<>(SuccessResponse.builder().build(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Response> login(LoginReq req) {
        validationUtils.validationRequest(req);

        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        String accessToken = userDao.getAccessToken(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).build());
        return new ResponseEntity<>(SuccessResponse.builder().data(LoginResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);

    }
    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {
        validationUtils.validationRequest(req);

        if(userDao.isExistsNickname(req.getAuthorization().getNickname()))
            throw CommonException.builder().code(Code.NICKNAME_BUSY).message("This username is already taken, please come up with another one.").httpStatus(HttpStatus.BAD_REQUEST).build();

        String accessToken = UUID.randomUUID().toString().replace("-","") + System.currentTimeMillis();
        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        userDao.insertNewUser(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).accessToken(accessToken).build());

        return new ResponseEntity<>(SuccessResponse.builder().data(RegistrationResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);

    }
}
