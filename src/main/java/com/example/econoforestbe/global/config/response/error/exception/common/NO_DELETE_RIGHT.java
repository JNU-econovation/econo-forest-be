package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NO_DELETE_RIGHT extends BusinessException {
    public NO_DELETE_RIGHT() {
        super(ErrorCode.NO_DELETE_RIGHT);
    }
}
