package com.example.econoforestbe.domain.Member;

public class Member {

    static Long id;

    private Long membeId = id;

    public Member() {
        this.membeId = id++;
    }

}
