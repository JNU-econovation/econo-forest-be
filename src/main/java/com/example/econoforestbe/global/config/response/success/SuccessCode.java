package com.example.econoforestbe.global.config.response.success;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum SuccessCode {

    CREATED_EAT_BOARD(HttpStatus.CREATED, "200100", "밥 먹어요 글이 생성되었습니다."),
    EDIT_EAT_BOARD(HttpStatus.OK, "200101", "밥 먹어요 글 수정 완료 했습니다."),
    PARTICIPATE_EAT_BOARD(HttpStatus.OK, "200102", "밥 먹어요 글에 참여했습니다."),
    NON_PARTICIPATE_EAT_BOARD(HttpStatus.OK, "200103", "밥 먹어요 글에 불참했습니다."),
    GET_EAT_BOARD(HttpStatus.OK, "200104", "밥 먹어요 글 조회 성공했습니다.");
    SuccessCode(HttpStatus httpStatus, String successCode, String message) {
        this.httpStatus = httpStatus;
        this.successCode = successCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String successCode;
    private String message;

}