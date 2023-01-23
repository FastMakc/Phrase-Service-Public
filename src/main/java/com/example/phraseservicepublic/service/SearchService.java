package com.example.phraseservicepublic.service;

import com.example.phraseservicepublic.domain.api.search.searchTags.SearchTagsReq;
import com.example.phraseservicepublic.domain.response.Response;
import org.springframework.http.ResponseEntity;

public interface SearchService {
    public ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken);
}
