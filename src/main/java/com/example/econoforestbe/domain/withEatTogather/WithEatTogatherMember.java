package com.example.econoforestbe.domain.withEatTogather;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherMembers;

public class WithEatTogatherMember {

    private final EatTogatherMembers eatTogatherMembers;

    private final Long memberId;

    public WithEatTogatherMember(EatTogatherMembers eatTogatherMembers, Long memberId) {
        this.eatTogatherMembers = eatTogatherMembers;
        this.memberId = memberId;
    }

    public void join() {
        eatTogatherMembers.addEatTogatherMember(memberId);
    }
}
