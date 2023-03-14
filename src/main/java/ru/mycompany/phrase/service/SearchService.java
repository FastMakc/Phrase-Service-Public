package ru.mycompany.phrase.service;

import ru.mycompany.phrase.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface SearchService {
    public ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken);
}
