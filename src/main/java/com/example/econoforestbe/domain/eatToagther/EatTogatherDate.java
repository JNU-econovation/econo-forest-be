package com.example.econoforestbe.domain.eatToagther;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Embeddable
@NoArgsConstructor
public class EatTogatherDate {

    @Transient
    private final String WARM = "[ERROR]";

    @Transient
    private final String WARM_CANT_BEFORE_DATE = " Can't record before today";

    @Column(name = "eating_date")
    private LocalDate date;

    @Column(name = "eating_time")
    private LocalTime time;


    public EatTogatherDate(LocalDateTime localDateTime) {
        validateDate(localDateTime.toLocalDate());
        this.date = localDateTime.toLocalDate();
        this.time = localDateTime.toLocalTime();
    }

    public void validateDate(LocalDate date) {
        if (date.isBefore(LocalDate.now())) {
            throw new DateTimeException(WARM_CANT_BEFORE_DATE);
        }
    }

    public boolean isBeforeTime(LocalDateTime localDateTime) {
        if (time.isBefore(localDateTime.toLocalTime())) {
            return true;
        }
        return false;
    }

}
