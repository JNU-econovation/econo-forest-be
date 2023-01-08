package com.example.econoforestbe.web.dto;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatInfo;
import com.example.econoforestbe.domain.eatBoard.EatMembers;
import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDate;


@Builder
@Getter
public class EatBoardResponseDto {
    private final LocalDate createdAt;
    private final LocalDate modifiedAt;
    private final LocalDate deletedAt;
    private final Long eatBoardId;
    private final TitleDto title;
    private final LocationCategory locationCategory;
    private final EatMembers eatMembers;
    private final EatInfo eatInfo;
}