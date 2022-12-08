package com.example.econoforestbe.eatBoard;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;

@Data
@Builder
public class Info {
    private LocalDate eatDate;
    private LocalTime eatTime;
}
