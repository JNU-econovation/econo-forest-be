package com.example.econoforestbe.web.dto;

import lombok.Getter;

import javax.validation.constraints.Future;

@Getter
public class EatReqDto {
    private String title;
    private String locationCategory;
    @Future
    private Long eatDateTime;
}
