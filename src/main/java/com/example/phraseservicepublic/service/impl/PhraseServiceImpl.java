package com.example.phraseservicepublic.service.impl;

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


@Slf4j
@Service
@RequiredArgsConstructor
public class PhraseServiceImpl implements PhraseService {

    private final ValidationUtils validationUtils;
    @Override
    public ResponseEntity<Response> registration(RegistrationReq req) {
        validationUtils.validationRequest(req);
        return new ResponseEntity<Response>((SuccessResponse.builder().data("Ол райт, Христофор Бонифатьевич!").build()), HttpStatus.OK);

    }
}
