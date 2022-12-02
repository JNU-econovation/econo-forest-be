package com.example.econoforestbe.domain.withEatTogather;


public class WithEatTogather {

    private final Long memberId;

    private final WithEatTogatherInfo withEatTogatherInfo;


    public WithEatTogather(Long memberId, WithEatTogatherInfo withEatTogatherInfo) {
        this.memberId = memberId;
        this.withEatTogatherInfo = withEatTogatherInfo;
    }


    public void participate() {
        validate();
    }

    private void validate() {
        withEatTogatherInfo.validate();
    }

}
