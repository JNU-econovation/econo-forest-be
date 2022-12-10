package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import lombok.Builder;

import javax.persistence.*;

@Builder
public class JoinEat {
    @Embedded
    private JoinInfo compareInfoByJoin;
    @OneToOne
    private EatBoard eatBoard;
    @Embedded
    private JoinMember joinMember;

    public boolean joinEatBoard(){
        return eatBoard.getEatMembers().addParticipant(joinMember.convertToEatParticipate());
    }
}
