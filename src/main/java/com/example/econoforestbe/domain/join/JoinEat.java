package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import lombok.Builder;

import javax.persistence.*;
import java.time.LocalDateTime;

@Builder
public class JoinEat {
    @Embedded
    private JoinInfo compareInfoByJoin;
    @OneToOne
    private EatBoard eatBoard;
    @Embedded
    private JoinMember joinMember;
}
