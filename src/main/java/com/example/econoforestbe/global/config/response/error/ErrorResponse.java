package com.example.econoforestbe.global.config.response.error;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.sql.Timestamp;
import java.util.List;
@Getter
@Builder
public class ErrorResponse {
    @Schema(description = "응답 시간", nullable = false, example = "167379449")
    private Timestamp timestamp;
    @Schema(description = "응답 코드", nullable = false, example = "400100")
    private String code;
    @Schema(description = "에러 클래스", nullable = false, example = "Exception.class")
    private String error;
    @Schema(description = "응답 메시지", nullable = false, example = "성공입니다")
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
