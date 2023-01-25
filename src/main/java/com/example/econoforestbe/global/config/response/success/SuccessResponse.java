package com.example.econoforestbe.global.config.response.success;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Timestamp;
@Getter
@Setter
public class SuccessResponse {
    @Getter
    public static class successWithDataBody<T> implements Serializable {
        @Schema(description = "응답 시간", nullable = false, example = "167379449")
        private Timestamp timestamp;
        @Schema(description = "응답 코드", nullable = false, example = "200100")
        private String code;
        @Schema(description = "응답 메시지", nullable = false, example = "성공입니다")
        private String message;
        @Schema(description = "응답 데이터", nullable = false)
        private T data;

        public successWithDataBody(T data, String code, String message) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.code = code;
            this.message = message;
            this.data = data;
        }
    }

    @Getter
    public static class successWithoutDataBody implements Serializable {
        @Schema(description = "응답 시간", nullable = false, example = "167379449")
        private Timestamp timestamp;
        @Schema(description = "응답 코드", nullable = false, example = "200100")
        private String code;
        @Schema(description = "응답 메시지", nullable = false, example = "성공입니다")
        private String message;

        public successWithoutDataBody(String code, String message) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.code = code;
            this.message = message;
        }
    }
}
