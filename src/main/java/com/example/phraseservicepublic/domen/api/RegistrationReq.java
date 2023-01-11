package com.example.phraseservicepublic.domen.api;

import com.example.phraseservicepublic.domen.constant.RegExp;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;


@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationReq {

    @NotNull(message = "Authorization must be filled in")
    private Authorization authorization;
}
