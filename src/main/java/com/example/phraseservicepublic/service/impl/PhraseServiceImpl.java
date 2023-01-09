package com.example.phraseservicepublic.service.impl;

import com.example.phraseservicepublic.dao.Dao;
import com.example.phraseservicepublic.domen.api.RegistrationReq;
import com.example.phraseservicepublic.domen.constant.Code;
import com.example.phraseservicepublic.domen.response.Response;
import com.example.phraseservicepublic.domen.response.SuccessResponse;
import com.example.phraseservicepublic.domen.response.exception.CommonException;
import com.example.phraseservicepublic.service.PhraseService;
import com.example.phraseservicepublic.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.nio.charset.StandardCharsets;
import java.util.UUID;


@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    private final ValidationUtils validationUtils;
    private final Dao dao;

    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {
        validationUtils.validationRequest(req);

        if(dao.isExistsNickname(req.getNickname()))
            throw CommonException.builder().code(Code.NICKNAME_BUSY).message("This username is already taken, please come up with another one.").httpStatus(HttpStatus.BAD_REQUEST).build();

        String accessToken = UUID.randomUUID().toString().replace("-","") + System.currentTimeMillis();
        String encryptPassword = DigestUtils.md5DigestAsHex(req.getPassword().getBytes());
        dao.insertNewUser(User.builder().nickname(req.getNickname()).encryptPassword(encryptPassword).accessToken(accessToken).build());
        return new ResponseEntity<>(SuccessResponse.builder().data(RegistrationResp.builder().accessToken(accessToken).build()).build(), HttpStatus.OK);

    }
}
