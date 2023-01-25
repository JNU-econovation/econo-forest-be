package com.example.econoforestbe.global.config.response.error.exception.eatBoard;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class ChangedInfoException extends BusinessException {
    public ChangedInfoException(){
        super(ErrorCode.CHANGED_INFO);
    }
}
