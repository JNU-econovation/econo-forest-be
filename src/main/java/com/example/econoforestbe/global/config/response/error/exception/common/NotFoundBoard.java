package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NotFoundBoard extends BusinessException {
    public NotFoundBoard() {
        super(ErrorCode.NOT_FOUND_BOARD);
    }
}
