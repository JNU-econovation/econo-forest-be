package com.example.econoforestbe.domain.withEatTogather;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogather;
import com.example.econoforestbe.domain.eatTogatherBoard.JoinMember;

public class WithEatTogatherMember {

    private final Long memberId;

    public WithEatTogatherMember(Long memberId) {
        this.memberId = memberId;
    }

    public void join(EatTogather eatTogather) {
        eatTogather.getEatTogatherMembers()
                .addEatTogatherMember(convertToJoinMember());
    }

    public JoinMember convertToJoinMember() {
        return new JoinMember(memberId);
    }
}
