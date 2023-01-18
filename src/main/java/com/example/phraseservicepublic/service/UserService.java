package com.example.phraseservicepublic.service;

import com.example.phraseservicepublic.domain.api.user.login.LoginReq;
import com.example.phraseservicepublic.domain.api.user.publicPhrases.PublicPhraseReq;
import com.example.phraseservicepublic.domain.api.user.registration.RegistrationReq;
import com.example.phraseservicepublic.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Response> getMyPhrases(String accessToken);

    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);
    ResponseEntity<Response> registration(RegistrationReq req);
    ResponseEntity<Response> login(LoginReq req);
}
