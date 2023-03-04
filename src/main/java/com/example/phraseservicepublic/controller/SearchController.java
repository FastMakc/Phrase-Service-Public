package com.example.phraseservicepublic.controller;

import com.example.phraseservicepublic.domain.api.search.searchTags.SearchTagsReq;
import com.example.phraseservicepublic.domain.response.Response;
import com.example.phraseservicepublic.service.SearchService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("phrase-service-public/search")
public class SearchController {


    private final SearchService searchService;

    @PostMapping("/searchPhrasesByTag")
    public ResponseEntity<Response> searchPhrasesByTag(@RequestHeader String accessToken, @RequestBody final SearchPhrasesByTagReq req) {

        log.info("START endpoint searchPhrasesByTag, accessToken: {}, request: {}", accessToken, req);
        ResponseEntity<Response> resp = searchService.searchPhrasesByTag(req, accessToken);
        log.info("END endpoint searchPhrasesByTag , response: {}", resp);
        return resp;
    }

    @PostMapping("/searchTags")
    public ResponseEntity<Response> searchTags(@RequestHeader String accessToken, @RequestBody final SearchTagsReq req) {

        log.info("START endpoint searchTags , accessToken: {}", accessToken, req);
        ResponseEntity<Response> resp = searchService.searchTags(req,accessToken);
        log.info("END point searchTags, response:{}", resp);
        return resp;
    }
}
