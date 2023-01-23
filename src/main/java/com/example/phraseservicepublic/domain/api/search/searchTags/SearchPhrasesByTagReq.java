package com.example.phraseservicepublic.domain.api.search.searchTags;

import com.example.phraseservicepublic.domain.constant.Sort;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotNull;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchPhrasesByTagReq {

    @DecimalMin(value = "1", message = "Value tagId must be greater than 0")
    private long tagId;

    @NotNull(message = "sort must be filled in")
    private Sort sort;
}
