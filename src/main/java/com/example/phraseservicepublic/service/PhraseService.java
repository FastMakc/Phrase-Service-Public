package com.example.phraseservicepublic.service;

import com.example.phraseservicepublic.domen.api.RegistrationReq;
import com.example.phraseservicepublic.domen.response.Response;
import org.springframework.http.ResponseEntity;

public interface PhraseService {
    ResponseEntity<Response> registration(RegistrationReq req);
}
