package com.example.phraseservicepublic.domen.response.error;

import com.example.phraseservicepublic.domen.response.Response;
import com.example.phraseservicepublic.domen.response.error.Error;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ErrorResponse implements Response {

    private Error error;
}
