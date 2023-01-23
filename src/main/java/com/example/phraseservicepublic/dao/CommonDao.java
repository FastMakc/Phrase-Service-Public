package com.example.phraseservicepublic.dao;

import com.example.phraseservicepublic.domain.api.search.searchTags.TagResp;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface CommonDao {
    List<TagResp> getTagsByPhraseId(long phraseId);
    long getUserIdByToken(String accessToken);
}
