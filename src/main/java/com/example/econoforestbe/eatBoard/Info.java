package com.example.econoforestbe.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@AllArgsConstructor
@Builder
public class Info {
    private LocalDate eatDateByJoin;
    private LocalTime eatTimeByJoin;

    public boolean deleteBoard(LocalDate dateBoard) {
        return eatDateByJoin.isAfter(dateBoard);
    }

    public boolean isAfter(LocalDate dateBoard, LocalTime dateTime) {
        return eatDateByJoin.isAfter(dateBoard)&&eatTimeByJoin.isAfter(dateTime);
    }
}
