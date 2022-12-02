package com.example.econoforestbe.domain.withEatTogather;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherInfo;

import java.time.LocalDateTime;

public class WithEatTogatherInfo {

    private EatTogatherInfo eatTogatherInfo;

    private LocalDateTime dateTime;

    private String location;


    public WithEatTogatherInfo(EatTogatherInfo eatTogatherInfo, LocalDateTime dateTime, String location) {
        this.eatTogatherInfo = eatTogatherInfo;
        this.dateTime = dateTime;
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public void validate() {
        eatTogatherInfo.validateWith(this);
    }
}
