package com.example.econoforestbe.domain.eatBoard;

import java.util.Arrays;

public enum LocationCategory {
    MAIN_GATE("정문"),
    BACK_GATE("후문"),
    BUSINESS_GATE("상대"),
    ENGINEERING_GATE("공대"),
    ART_GATE("예대");

    private static final String NOT_FOUND_LOCATION_CATEGORY = "해당 위치 카테고리는 없습니다";
    private final String location;

    LocationCategory(String location) {
        this.location = location;
    }

    private String getLocation() {
        return location;
    }

    /**
     * @param location 위치 카테고리
     * @return LocationCategory
     */
    public static LocationCategory hasCategory(String location) {
        return Arrays.stream(LocationCategory.values())
                .filter(x -> x.getLocation().equals(location))
                .findAny()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_LOCATION_CATEGORY));
    }
}