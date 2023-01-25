package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NoDeleteRight extends BusinessException {
    public NoDeleteRight() {
        super(ErrorCode.NO_DELETE_RIGHT);
    }
}
