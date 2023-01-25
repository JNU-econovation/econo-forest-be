package com.example.econoforestbe.domain.eatBoard;

public enum EatMemberType {
    AUTHOR("AUTHOR"), PARTICIPANT("PARTICIPANT"), NON_PARTICIPATE("NONPARTICIPATE");
    private String type;

    EatMemberType(String type) {
        this.type = type;
    }

    public String getType(){
        return type;
    }
}
