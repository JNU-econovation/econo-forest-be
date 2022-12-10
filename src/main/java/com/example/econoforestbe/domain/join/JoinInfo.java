package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.Info;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@NoArgsConstructor
public class JoinInfo {
    private LocalDate eatDateByJoin=LocalDate.now();
    private LocalTime eatTimeByJoin=LocalTime.now();

    public Info convertToInfo() {
        return new Info(eatDateByJoin,eatTimeByJoin);
    }
}
