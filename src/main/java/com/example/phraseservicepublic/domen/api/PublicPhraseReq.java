package com.example.phraseservicepublic.domen.api;

import com.example.phraseservicepublic.domen.constant.RegExp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PublicPhraseReq {

    @NotBlank(message = "text must be filled in")
    @Pattern(regexp = RegExp.phrase, message = "Incorrect text")
    private String text;

    @Size(max = 5, message = "the number of tags must not exceed 5")
    private List <
         @NotBlank(message = "tag must be filled in")
         @Pattern(regexp = RegExp.tag, message = "Incorrect tag")
            String> tags;



}
