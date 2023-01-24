package com.example.econoforestbe.global.config.response.error;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public enum ErrorCode {
    //공통
    NO_DELETE_RIGHT(HttpStatus.FORBIDDEN, "403001", "글 생성자만 글을 삭제할 수 있습니다."),
    NO_EDIT_RIGHT(HttpStatus.FORBIDDEN, "403002", "글 생성자만 글을 수정할 수 있습니다."),
    NOT_FOUND_BOARD(HttpStatus.BAD_REQUEST, "400003", "존재하지 않는 글입니다."),
    NOT_CREATED_EMPTY_BOARD(HttpStatus.BAD_REQUEST, "400004", "빈 제목은 생성할 수 없습니다."),

    //밥 먹어요
    ALREADY_PARTICIPATE(HttpStatus.BAD_REQUEST, "400101", "이미 해당 밥 먹어요 글에 참여했습니다."),
    NO_PARTICIPATE(HttpStatus.BAD_REQUEST, "400102", "원래 해당 밥 먹어요 글에 참여하지 않았습니다."),
    CHANGED_INFO(HttpStatus.BAD_REQUEST, "400103", "밥 먹어요 글이 변경되었습니다. 확인해주세요");


    ErrorCode(HttpStatus httpStatus, String errorCode, String message) {
        this.httpStatus = httpStatus;
        this.errorCode = errorCode;
        this.message = message;
    }

    private HttpStatus httpStatus;
    private String errorCode;
    private String message;

}


