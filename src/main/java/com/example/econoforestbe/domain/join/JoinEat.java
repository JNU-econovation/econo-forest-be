package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;

import javax.persistence.*;
import java.time.LocalDateTime;

public class JoinEat {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime joinDateTime;
    @Embedded
    private JoinInfo compareInfoByJoin;
    @OneToOne
    private EatBoard eatBoard;
    @Embedded
    private JoinMember joinMember;
}
