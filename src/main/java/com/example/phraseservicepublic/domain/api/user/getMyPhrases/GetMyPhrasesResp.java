package com.example.phraseservicepublic.domain.api.user.getMyPhrases;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetMyPhrasesResp {
    private String accessToken;
}
