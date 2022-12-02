package com.example.econoforestbe.domain.withEatTogather;

import com.example.econoforestbe.domain.eatTogatherBoard.Info;

import java.time.LocalDateTime;

public class WithEatTogatherInfo {

    private LocalDateTime dateTime;

    private String location;

    public WithEatTogatherInfo(LocalDateTime dateTime, String location) {
        this.dateTime = dateTime;
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }

    public Info convertToInfo() {
        return new Info(dateTime, location);
    }
}
