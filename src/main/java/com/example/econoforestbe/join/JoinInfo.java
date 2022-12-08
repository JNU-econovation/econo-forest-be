package com.example.econoforestbe.join;

import com.example.econoforestbe.eatBoard.EatInfo;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@NoArgsConstructor
public class JoinInfo {
    private LocalDate eatDateByJoin;
    private LocalTime eatTimeByJoin;

}
