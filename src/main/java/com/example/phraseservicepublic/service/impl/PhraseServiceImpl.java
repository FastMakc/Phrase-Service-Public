package com.example.phraseservicepublic.service.impl;

import com.example.phraseservicepublic.dao.Dao;
import com.example.phraseservicepublic.domen.api.LoginReq;
import com.example.phraseservicepublic.domen.api.LoginResp;
import com.example.phraseservicepublic.domen.api.RegistrationReq;
import com.example.phraseservicepublic.domen.api.RegistrationResp;
import com.example.phraseservicepublic.domen.constant.Code;
import com.example.phraseservicepublic.domen.dto.User;
import com.example.phraseservicepublic.domen.response.Response;
import com.example.phraseservicepublic.domen.response.SuccessResponse;
import com.example.phraseservicepublic.domen.response.exception.CommonException;
import com.example.phraseservicepublic.service.PhraseService;
import com.example.phraseservicepublic.util.EncryptUtils;
import com.example.phraseservicepublic.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Slf4j
@Component
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    private final ValidationUtils validationUtils;
    private final EncryptUtils encryptUtils;
    private final Dao dao;

    @Override
    public ResponseEntity<Response> login(LoginReq req) {
        validationUtils.validationRequest(req);

        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        String accessToken = dao.getAccessToken(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).build());
        return new ResponseEntity<>(SuccessResponse.builder().data(LoginResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);

    }
    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {
        validationUtils.validationRequest(req);

        if(dao.isExistsNickname(req.getAuthorization().getNickname()))
            throw CommonException.builder().code(Code.NICKNAME_BUSY).message("This username is already taken, please come up with another one.").httpStatus(HttpStatus.BAD_REQUEST).build();

        String accessToken = UUID.randomUUID().toString().replace("-","") + System.currentTimeMillis();
        String encryptPassword = encryptUtils.encryptPassword(req.getAuthorization().getPassword());
        dao.insertNewUser(User.builder().nickname(req.getAuthorization().getNickname()).encryptPassword(encryptPassword).accessToken(accessToken).build());

        return new ResponseEntity<>(SuccessResponse.builder().data(RegistrationResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);

    }
}
