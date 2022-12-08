package com.example.econoforestbe.eatBoard;

import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.Period;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EatDateTime {
    private static final Long OVER_DAY = 1L;
    private LocalDate eatDate;
    private LocalTime eatTime;
    private static final String ONLY_SUBSEQUENT_TIME_CREATED = "현재 시간보다 이후 시간으로만 정보 생성가능합니다";

    public EatDateTime(LocalDate eatDate, LocalTime eatTime) {
        validateSubsequentTime(eatDate, eatTime);
        this.eatDate = eatDate;
        this.eatTime = eatTime;
    }

    private void validateSubsequentTime(LocalDate eatDate, LocalTime eatTime) {
        if (eatDate.isBefore(LocalDate.now()) || eatTime.isBefore(LocalTime.now())) {
            throw new IllegalArgumentException(ONLY_SUBSEQUENT_TIME_CREATED);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatDateTime)) return false;
        EatDateTime that = (EatDateTime) o;
        return Objects.equals(eatDate, that.eatDate) && Objects.equals(eatTime, that.eatTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(eatDate, eatTime);
    }
}

