package com.example.econoforestbe.join;

import com.example.econoforestbe.eatBoard.EatDateTime;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@NoArgsConstructor
public class EatInfoByJoin {
    private LocalDate eatDateByJoin;
    private LocalTime eatTimeByJoin;

    private boolean compareInfo(EatDateTime eatDateTime){
        return eatDateTime.equals(this);
    }
}
