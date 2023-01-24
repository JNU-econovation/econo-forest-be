package com.example.econoforestbe.global.config.response.error.exception.common;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NotFoundWriter extends BusinessException {
    public NotFoundWriter() {
        super(ErrorCode.NOT_FOUND_WRITER);
    }
}
