package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.global.config.response.error.exception.eatBoard.NotExistsCategory;

import javax.persistence.Column;
import java.util.Arrays;
public enum LocationCategory {
    MAIN_GATE("MAINGATE"),
    BUSINESS_GATE("BUSINESSGATE"),
    ENGINEERING_GATE("ENGINEERINGGATE"),
    ART_GATE("ARTGATE");
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
                .orElseThrow(NotExistsCategory::new);
    }
}