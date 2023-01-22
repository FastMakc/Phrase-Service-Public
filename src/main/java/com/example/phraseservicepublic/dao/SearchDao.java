package com.example.phraseservicepublic.dao;

import com.example.phraseservicepublic.domain.api.search.searchTags.TagResp;

import java.util.List;

public interface SearchDao {

    public List<TagResp> searchTags(String partTag);

}
