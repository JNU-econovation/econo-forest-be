package com.example.econoforestbe.global.config.response;

import com.example.econoforestbe.global.config.response.error.ErrorResponse;
import com.example.econoforestbe.global.config.response.success.SuccessResponse.successWithDataBody;
import lombok.experimental.UtilityClass;
import org.springframework.http.HttpStatus;
import org.springframework.util.MultiValueMap;

import static com.example.econoforestbe.global.config.response.success.SuccessResponse.*;

@UtilityClass
public class ResponseGenerator {

    public static <D> ResponseDto<successWithDataBody> success(final D data,
                                                               final HttpStatus status,
                                                               final String code, final String message) {
        return new ResponseDto<>(new successWithDataBody<>(data, code, message), status);
    }

    public static ResponseDto<successWithoutDataBody> success(
            final HttpStatus status,
            final String code, final String message) {
        return new ResponseDto<>(new successWithoutDataBody(code, message), status);
    }

    public static ResponseDto<successWithoutDataBody> create(
            final HttpStatus status,
            final String code, final String message, final MultiValueMap<String, String> headers) {
        return new ResponseDto<>(new successWithoutDataBody(code, message), headers, status);
    }

    public static ResponseDto<ErrorResponse> fail(
            final HttpStatus status,
            final String code, final String error, final String message) {
        return new ResponseDto<>(ErrorResponse.of(code, error, message), status);
    }
}