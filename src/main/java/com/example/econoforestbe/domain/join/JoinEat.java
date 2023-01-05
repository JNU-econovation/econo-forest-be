package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
public class JoinEat {
    @Embedded
    private JoinInfo compareInfoByJoin;
    @OneToOne
    private Long eatBoardId;
    @Embedded
    private JoinMember joinMember;
}
