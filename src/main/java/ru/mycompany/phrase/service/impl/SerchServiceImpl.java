package ru.mycompany.phrase.service.impl;

import com.example.phraseservicepublic.dao.SearchDao;
import com.example.phraseservicepublic.dao.UserDao;
import ru.mycompany.phrase.domain.api.user.getMyPhrases.PhraseResp;
import ru.mycompany.phrase.domain.response.Response;
import ru.mycompany.phrase.domain.response.SuccessResponse;
import ru.mycompany.phrase.service.SearchService;
import ru.mycompany.phrase.util.ValidationUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class SerchServiceImpl implements SearchService {
    private final SearchDao searchDao;
    private final ValidationUtils validationUtils;
    private final UserDao userDao;

    @Override
    public ResponseEntity<Response> searchPhrasesByTag(SearchPhrasesByTagReq req, String accessToken) {

        validationUtils.validationRequest(req);
        long userId = commonDao.getUserIdByToken(accessToken);

        List<PhraseResp> phrases = searchDao.searchPhrasesByTag(req, userId);
        commonService.phraseEnrichment(phrases);

        return new ResponseEntity<>(SuccessResponse.builder().data(CommonPhrasesResp.builder().phrases(phrases).build()).build(), HttpStatus.OK);
    }


    @Override
    public ResponseEntity<Response> searchTags(SearchTagsReq req, String accessToken) {

        validationUtils.validationRequest(req);
        userDao.getIdByToken(accessToken);

        List<TagResp> tagRespList = searchDao.searchTags(req.getPartTag());
        return new ResponseEntity<>(SuccessResponse.builder().data(SearchTagsResp.builder().tags(tagRespList).build()).build(), HttpStatus.OK);
    }
}
