package com.example.econoforestbe.web.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.Getter;

import javax.validation.constraints.Future;

@Schema(description = "밥 먹어요 생성/수정 요청DTO")
@Getter
public class EatReqDto {
    @Schema(description = "제목", example = "제목1")
    private String title;
    @Schema(description = "장소 카테고리", example = "MAINGATE")
    private String locationCategory;
    @Schema(description = "생성 날짜/시간", example = "167379449")
    private Long eatDateTime;
}
