package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NOT_FOUND_BOARD extends BusinessException {
    public NOT_FOUND_BOARD() {
        super(ErrorCode.NOT_FOUND_BOARD);
    }
}
