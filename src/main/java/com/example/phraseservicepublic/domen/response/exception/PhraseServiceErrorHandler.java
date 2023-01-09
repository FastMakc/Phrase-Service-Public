package com.example.phraseservicepublic.domen.response.exception;

import com.example.phraseservicepublic.domen.response.error.Error;
import com.example.phraseservicepublic.domen.response.error.ErrorResponse;
import com.example.phraseservicepublic.domen.constant.Code;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class PhraseServiceErrorHandler {

    @ExceptionHandler(CommonException.class)
    public ResponseEntity<ErrorResponse> handleCommonException(CommonException ex) {
        log.error("common error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(ex.getCode()).message(ex.getMessage()).build()).build(), ex.getHttpStatus());

    }

    @ExceptionHandler (Exception.class)
    public ResponseEntity<ErrorResponse> handleUnexpectedErrorException(Exception ex) {
        ex.printStackTrace();
        log.error("internal server error: {}", ex.toString());
        return new ResponseEntity<>(ErrorResponse.builder().error(Error.builder().code(Code.INTERNAL_SERVER_ERROR).message("Internal service error").build()).build(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
