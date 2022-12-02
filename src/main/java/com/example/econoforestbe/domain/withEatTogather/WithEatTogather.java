package com.example.econoforestbe.domain.withEatTogather;


import com.example.econoforestbe.domain.eatTogatherBoard.EatTogather;

public class WithEatTogather {
    private EatTogather eatTogather;

    private WithEatTogatherInfo withEatTogatherInfo;

    private WithEatTogatherMember withEatTogatherMember;


    public WithEatTogather(EatTogather eatTogather, WithEatTogatherInfo withEatTogatherInfo, WithEatTogatherMember withEatTogatherMember) {
        this.eatTogather = eatTogather;
        this.withEatTogatherInfo = withEatTogatherInfo;
        this.withEatTogatherMember = withEatTogatherMember;
    }


    public void participate() {
        validate();
        join(eatTogather);
    }

    private void validate() {
        withEatTogatherInfo.validate();
    }

    private void join(EatTogather eatTogather) {
        withEatTogatherMember.join(eatTogather);
    }

}
