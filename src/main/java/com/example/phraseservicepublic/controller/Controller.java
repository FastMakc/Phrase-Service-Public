package com.example.phraseservicepublic.controller;

import com.example.phraseservicepublic.domen.api.LoginReq;
import com.example.phraseservicepublic.domen.api.PublicPhraseReq;
import com.example.phraseservicepublic.domen.api.RegistrationReq;
import com.example.phraseservicepublic.domen.response.Response;
import com.example.phraseservicepublic.service.PhraseService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public")
public class Controller {

    private final PhraseService phraseService;

    @GetMapping("/hello")
    public String hello() {
        String hello = "Hello, phrase-service! Version: 1.0.0";
        log.info(hello);
        return hello;
    }

    @PostMapping("/publicPhrase")
    public ResponseEntity<Response> publicPhrase(@RequestHeader final String accessToken, @RequestBody final PublicPhraseReq req) {
        log.info("START endpoint publicPhrase, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = phraseService.publicPhrase(req, accessToken);
        log.info("END endpoint publicPhrase, response: {}", resp);
        return resp;
    }

    @PostMapping("/login")
    public ResponseEntity<Response> login(@RequestBody final LoginReq req) {
        log.info("START endpoint login, request: {}", req);
        ResponseEntity<Response> resp = phraseService.login(req);
        log.info("END endpoint login, response: {}", resp);
        return resp;

    }

    @PostMapping("/registration")
    public ResponseEntity<Response> registration(@RequestBody final RegistrationReq req) {

        log.info("START endpoint registration, request: {}", req);
        ResponseEntity<Response> resp = phraseService.registration(req);
        log.info("END endpoint registration, response: {}", resp);
        return resp;
    }
}
