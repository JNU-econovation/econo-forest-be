package com.example.econoforestbe.global.config.response.success;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {

    CREATED_EAT_BOARD(HttpStatus.CREATED, "200100", "밥 먹어요 글이 생성되었습니다."),
    EDIT_EAT_BOARD(HttpStatus.OK, "200101", "밥 먹어요 글 수정 완료 했습니다.");
    SuccessCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

}