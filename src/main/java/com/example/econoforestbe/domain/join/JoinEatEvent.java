package com.example.econoforestbe.domain.join;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import javax.persistence.Embedded;
import javax.persistence.OneToOne;

@NoArgsConstructor
@AllArgsConstructor
@Getter
//이벤트를 처리하는 데이터를 포함
public class JoinEatEvent {
    @OneToOne
    private Long eatBoardId;
    @Embedded
    private JoinInfo compareInfoByJoin;
    @Embedded
    private JoinMember joinMember;
}
