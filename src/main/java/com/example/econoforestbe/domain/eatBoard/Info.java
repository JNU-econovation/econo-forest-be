package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.Objects;

@Getter
public class Info {
    private LocalDateTime localDateTime;
    private LocationCategory locationCategory;
    @Builder
    public Info(LocalDateTime localDateTime, LocationCategory locationCategory) {
        this.localDateTime = localDateTime;
        this.locationCategory = locationCategory;
    }
}
