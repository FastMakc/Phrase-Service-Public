package com.example.phraseservicepublic.domen.api;

import com.example.phraseservicepublic.domen.constant.RegExp;
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
public class Authorization {

    @NotBlank(message = "Nickname must be filled in")
    @Pattern(regexp = RegExp.nickname, message = "Incorrect nickname")
    private String nickname;

    @NotBlank(message = "Nickname must be filled in")
    @Pattern(regexp = RegExp.password, message = "Incorrect nickname")
    private String password;
}
