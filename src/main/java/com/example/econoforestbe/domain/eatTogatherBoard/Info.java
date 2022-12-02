package com.example.econoforestbe.domain.eatTogatherBoard;

import java.time.LocalDateTime;

public class Info {

    private LocalDateTime dateTime;

    private String location;

    public Info(LocalDateTime dateTime, String location) {
        this.dateTime = dateTime;
        this.location = location;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public String getLocation() {
        return location;
    }
}
