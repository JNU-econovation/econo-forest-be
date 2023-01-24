package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NO_EDIT_RIGHT extends BusinessException {
    public NO_EDIT_RIGHT() {
        super(ErrorCode.NO_EDIT_RIGHT);
    }
}
