package com.example.econoforestbe.global.config.response.success;

import lombok.Getter;

import java.io.Serializable;
import java.sql.Timestamp;

public class SuccessResponse {
    @Getter
    public static class successWithDataBody<T> implements Serializable {
        private Timestamp timestamp;
        private String code;
        private String message;
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
        private Timestamp timestamp;
        private String code;
        private String message;

        public successWithoutDataBody(String code, String message) {
            this.timestamp = new Timestamp(System.currentTimeMillis());
            this.code = code;
            this.message = message;
        }
    }
}
