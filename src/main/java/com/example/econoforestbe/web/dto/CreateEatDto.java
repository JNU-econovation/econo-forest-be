package com.example.econoforestbe.web.dto;

import com.example.econoforestbe.domain.eatBoard.*;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;

@Getter
//TODO : createEatDto idpId -> AccessToken으로 변경
public class CreateEatDto {
    private String title;
    private String locationCategory;
    private LocalDate eatDate;
    private LocalTime eatTime;
    private Long idpId;
}
