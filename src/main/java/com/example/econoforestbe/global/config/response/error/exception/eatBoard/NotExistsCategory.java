package com.example.econoforestbe.global.config.response.error.exception.eatBoard;

import com.example.econoforestbe.global.config.response.error.ErrorCode;
import com.example.econoforestbe.global.config.response.error.exception.BusinessException;

public class NotExistsCategory extends BusinessException {
    public NotExistsCategory(){
        super(ErrorCode.NOT_EXISTS_CATEGORY);
    }
}

