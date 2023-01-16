package com.example.phraseservicepublic.domain.response.exception;

import com.example.phraseservicepublic.domain.constant.Code;
import lombok.Builder;
import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
@Builder
public class CommonException extends RuntimeException{

    private final Code code;
    private final String message;
    private final HttpStatus httpStatus;
}
