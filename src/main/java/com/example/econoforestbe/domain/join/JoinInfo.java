package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.Info;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
public class JoinInfo {
    private LocalDate eatDateWhenJoin;
    private LocalTime eatTimeWhenJoin;

    public Info convertToInfo() {
        return Info.builder()
                .eatDate(eatDateWhenJoin)
                .eatTime(eatTimeWhenJoin)
                .build();
    }
}
