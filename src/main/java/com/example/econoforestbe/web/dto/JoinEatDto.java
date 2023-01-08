package com.example.econoforestbe.web.dto;

import com.example.econoforestbe.domain.eatBoard.EatParticipate;
import com.example.econoforestbe.domain.eatBoard.Info;
import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import com.example.econoforestbe.domain.join.JoinEat;
import com.example.econoforestbe.domain.join.JoinInfo;
import com.example.econoforestbe.domain.join.JoinMember;
import com.example.econoforestbe.util.EpochTime;
import lombok.Builder;
import lombok.Getter;

import java.time.LocalDateTime;


@Getter
@Builder
public class JoinEatDto {
    private Long eatBoardId;
    private Long idpId;
    private Long eatInfo;
    private String locationCategory;

    public JoinEat toJoinEat(){
        return JoinEat.builder()
                .compareInfoByJoin(toJoinInfo())
                .eatBoardId(eatBoardId)
                .joinMember(toJoinMember())
                .build();
    }

    public JoinInfo toJoinInfo(){
        return JoinInfo.builder()
                .eatInfoWhenJoin(EpochTime.toLocalDateTime(eatInfo))
                .locationCategory(LocationCategory.hasCategory(locationCategory))
                .build();
    }

    public JoinMember toJoinMember(){
        return JoinMember.builder()
                .idpId(idpId)
                .build();
    }
}
