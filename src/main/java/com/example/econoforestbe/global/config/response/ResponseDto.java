package com.example.econoforestbe.global.config.response;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;


@Getter
public class ResponseDto<T> extends ResponseEntity<T> {

    public ResponseDto(T body, HttpStatus status) {
        super(body, status);
    }

    public ResponseDto(T body, MultiValueMap<String, String> headers, HttpStatus status) {
        super(body, headers, status);
    }

}
