package com.kittyvt.restapi.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;

import java.time.LocalDateTime;

public class ResponseEntityBuilderResponse<T> {
    private Object response;
    private HttpStatus status;
    private String message;
    private String error;
    private MultiValueMap<String, String> headers;

    public ResponseEntityBuilderResponse<T> setHeaders(MultiValueMap<String, String> headers) {
        this.headers = headers;
        return this;
    }

    public ResponseEntityBuilderResponse<T> setError(String error) {
        this.error = error;
        return this;
    }

    public ResponseEntityBuilderResponse<T> setMessage(String message) {
        this.message = message;
        return this;
    }

    public ResponseEntityBuilderResponse<T> setStatus(HttpStatus status) {
        this.status = status;
        return this;
    }

    public ResponseEntityBuilderResponse<T> setResponse(Object response) {
        this.response = response;
        return this;
    }

    public ResponseEntity<Object> build() {
        ResponseObject responseObject = new ResponseObject(LocalDateTime.now(), response, status, message, error);
        return new ResponseEntity<>(responseObject, headers, status);
    }
}
