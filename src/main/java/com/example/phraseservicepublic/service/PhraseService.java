package com.example.phraseservicepublic.service;

import com.example.phraseservicepublic.domain.api.LoginReq;
import com.example.phraseservicepublic.domain.api.PublicPhraseReq;
import com.example.phraseservicepublic.domain.api.RegistrationReq;
import com.example.phraseservicepublic.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface PhraseService {
    ResponseEntity<Response> getMyPhrases(long accessToken);

    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);
    ResponseEntity<Response> registration(RegistrationReq req);
    ResponseEntity<Response> login(LoginReq req);
}
