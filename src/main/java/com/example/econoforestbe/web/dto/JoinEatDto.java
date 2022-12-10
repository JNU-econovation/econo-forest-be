package com.example.econoforestbe.web.dto;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class JoinEatDto {
    private LocalDate eatDateWhenJoin;
    private LocalTime eatTimeWhenJoin;
    private Long eatBoardId;
    private Long joinMemberId;
}
