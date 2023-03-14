package ru.mycompany.phrase.service;

import ru.mycompany.phrase.domain.api.user.login.LoginReq;
import ru.mycompany.phrase.domain.api.user.publicPhrases.PublicPhraseReq;
import ru.mycompany.phrase.domain.api.user.registration.RegistrationReq;
import ru.mycompany.phrase.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface UserService {
    ResponseEntity<Response> getMyPhrases(String accessToken);

    ResponseEntity<Response> publicPhrase(PublicPhraseReq req, String accessToken);
    ResponseEntity<Response> registration(RegistrationReq req);
    ResponseEntity<Response> login(LoginReq req);
}
