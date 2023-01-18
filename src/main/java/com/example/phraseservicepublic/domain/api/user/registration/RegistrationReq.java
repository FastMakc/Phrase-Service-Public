package com.example.phraseservicepublic.domain.api.user.registration;

import com.example.phraseservicepublic.domain.api.user.common.Authorization;
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
