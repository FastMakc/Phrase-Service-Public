package com.example.phraseservicepublic.domain.api.search.searchTags;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SrachTagsResp {

    private List<TagResp> tags;
}
