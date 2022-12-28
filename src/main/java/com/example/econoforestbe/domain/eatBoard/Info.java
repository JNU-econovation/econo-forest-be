package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Objects;

@Data
@AllArgsConstructor
@Builder
public class Info {
    private LocalDate eatDate;
    private LocalTime eatTime;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Info)) return false;
        Info info = (Info) o;
        return Objects.equals(getEatDate(), info.getEatDate()) && Objects.equals(getEatTime(), info.getEatTime());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getEatDate(), getEatTime());
    }
}
