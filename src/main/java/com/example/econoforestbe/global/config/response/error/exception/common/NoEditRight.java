package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NoEditRight extends BusinessException {
    public NoEditRight() {
        super(ErrorCode.NO_EDIT_RIGHT);
    }
}
