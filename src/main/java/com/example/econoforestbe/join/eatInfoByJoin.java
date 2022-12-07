package com.example.econoforestbe.join;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@NoArgsConstructor
public class eatInfoByJoin {
    private LocalDate eatDateByJoin;
    private LocalTime eatTimeByJoin;
}
