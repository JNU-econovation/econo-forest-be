package com.example.econoforestbe.web.dto;

import java.util.Arrays;
import java.util.NoSuchElementException;

public enum EatLocation {
    BACK("후문"),
    FRONT("정문"),
    BUSINESS("상대"),
    ENGINEERING("공대"),
    ART("예대"),
    ;

    private static final String WARM = "[ERROR]";
    private static final String WARM_NO_SUCH_LOCATION = WARM + " no such location";
    private final String location;

    EatLocation(String location) {
        this.location = location;
    }

    public static EatLocation makeLocation(String location) {
        return Arrays.stream(EatLocation.values())
                .filter(eatLocation -> eatLocation.getLocation()
                        .equals(location))
                .findFirst()
                .orElseThrow(() -> new NoSuchElementException(WARM_NO_SUCH_LOCATION));
    }

    public String getLocation() {
        return location;
    }

}
