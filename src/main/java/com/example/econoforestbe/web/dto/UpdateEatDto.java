package com.example.econoforestbe.web.dto;

import lombok.Getter;

@Getter
public class UpdateEatDto {
    private Long boardId;
    private String title;
    private Long date;
    private String location;
}
