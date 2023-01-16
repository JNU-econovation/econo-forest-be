package com.example.econoforestbe.web.dto;

import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
public class JoinEatDto {
    //현재 DB 정보랑, 참여할 때 정보가 같은지 확인
    private Long eatInfo;
    private String locationCategory;
}
