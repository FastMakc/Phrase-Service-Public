package com.example.phraseservicepublic.domain.response.error;

import com.example.phraseservicepublic.domain.response.Response;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}
