package com.example.econoforestbe.domain.withEatTogather;


public class WithEatTogather {

    private WithEatTogatherInfo withEatTogatherInfo;

    private WithEatTogatherMember withEatTogatherMember;


    public WithEatTogather(WithEatTogatherInfo withEatTogatherInfo, WithEatTogatherMember withEatTogatherMember) {
        this.withEatTogatherInfo = withEatTogatherInfo;
        this.withEatTogatherMember = withEatTogatherMember;
    }


    public void participate() {
        validate();
    }

    private void validate() {
        withEatTogatherInfo.validate();
    }

}
