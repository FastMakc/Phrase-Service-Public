package com.example.phraseservicepublic.domain.api.search.searchTags;

import com.example.phraseservicepublic.domain.constant.RegExp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SearchTagsReq {

    @NotBlank(message = "partTag must be filled in")
    @Pattern(regexp = RegExp.tag, message = "incorrect partTag")
    private String partTag;
}
