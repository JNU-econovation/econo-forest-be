package com.example.econoforestbe.global.config.response.error;

import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.util.List;

@Getter
@Builder
public class ErrorResponse {
    private Timestamp timestamp;
    private String code;
    private String error;
    private String message;

    public static ErrorResponse of(String code, String error, String message) {
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .error(error)
                .code(code)
                .message(message)
                .build();
    }

    public static ErrorResponse of(String code, BindingResult bindingResult) {
        return ErrorResponse.builder()
                .timestamp(new Timestamp(System.currentTimeMillis()))
                .code(code)
                .error(bindingResult.getObjectName())
                .message(createErrorMessage(bindingResult))
                .build();
    }

    private static String createErrorMessage(BindingResult bindingResult) {
        StringBuilder sb = new StringBuilder();
        boolean isFirst = true;

        List<FieldError> fieldErrors = bindingResult.getFieldErrors();
        for (FieldError fieldError : fieldErrors) {
            if(!isFirst) {
                sb.append(", ");
            } else {
                isFirst = false;
            }
            sb.append("[");
            sb.append(fieldError.getField());
            sb.append("] ");
            sb.append(fieldError.getDefaultMessage());
        }

        return sb.toString();
    }

}
