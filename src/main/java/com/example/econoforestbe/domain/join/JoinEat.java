package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import javax.persistence.*;

@Builder
@Getter
@AllArgsConstructor
public class JoinEat {

    @Embedded
    private JoinInfo compareInfoByJoin;
    @OneToOne
    private Long eatBoardId;
    @Embedded
    private JoinMember joinMember;

    public void compare(JoinValidator joinValidator){
        joinValidator.validate(this);
    }
    
}
