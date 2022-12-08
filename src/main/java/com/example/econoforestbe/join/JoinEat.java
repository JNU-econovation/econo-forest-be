package com.example.econoforestbe.join;

import com.example.econoforestbe.eatBoard.EatBoard;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
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
