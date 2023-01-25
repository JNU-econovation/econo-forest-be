package com.example.econoforestbe.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
public class JoinEatDto {
    @Schema(description = "날짜/시간", example = "167379449")
    private Long eatInfo;
    @Schema(description = "장소 카테고리", example = "MAINGATE")
    private String locationCategory;
}
