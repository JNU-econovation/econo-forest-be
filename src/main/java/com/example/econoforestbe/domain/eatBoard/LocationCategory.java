package com.example.econoforestbe.domain.eatBoard;

import java.util.Arrays;

public enum LocationCategory {
    MAIN_GATE("MainGate"),
    BACK_GATE("BackGate"),
    BUSINESS_GATE("BusinessGate"),
    ENGINEERING_GATE("EngineeringGate"),
    ART_GATE("ArtGate");

    private static final String NOT_FOUND_LOCATION_CATEGORY = "해당 위치 카테고리는 없습니다";
    private String location;

    LocationCategory(String location){
        this.location=location;
    }

    public String getLocation(){
        return location;
    }

    /**
     * @param location 위치 카테고리
     * @return LocationCategory
     */
    public static LocationCategory hasCategory(String location) {
        return Arrays.stream(LocationCategory.values())
                .filter(x->x.getLocation().equals(location))
                .findAny()
                .orElseThrow(() -> new RuntimeException(NOT_FOUND_LOCATION_CATEGORY));
    }
}