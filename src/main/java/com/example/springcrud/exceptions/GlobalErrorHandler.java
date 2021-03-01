package com.example.springcrud.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalErrorHandler {
    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseBody
    public ResponseError handleCustomException(ResourceNotFoundException ex) {
        ResponseError responseError = new ResponseError();
        responseError.setErrorMessage(ex.getMessage());
        responseError.setStatusCode(HttpStatus.NOT_FOUND.value());
        return responseError;

    }
}
