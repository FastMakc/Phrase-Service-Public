package com.example.phraseservicepublic.service;

import com.example.phraseservicepublic.domen.api.LoginReq;
import com.example.phraseservicepublic.domen.api.PublicPhraseReq;
import com.example.phraseservicepublic.domen.api.RegistrationReq;
import com.example.phraseservicepublic.domen.response.Response;
import org.springframework.http.ResponseEntity;

public interface PhraseService {
    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);
    ResponseEntity<Response> registration(RegistrationReq req);
    ResponseEntity<Response> login(LoginReq req);
}