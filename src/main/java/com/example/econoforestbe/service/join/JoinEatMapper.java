package com.example.econoforestbe.service.join;

import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import com.example.econoforestbe.domain.join.JoinEat;
import com.example.econoforestbe.domain.join.JoinInfo;
import com.example.econoforestbe.domain.join.JoinMember;
import com.example.econoforestbe.util.EpochTime;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class JoinEatMapper {
    public JoinEat mapFrom(Long idpId, Long eatBoardId, JoinEatDto joinEatDto) {
        return JoinEat.builder()
                .compareInfoByJoin(toJoinInfo(joinEatDto.getEatInfo(), joinEatDto.getLocationCategory()))
                .eatBoardId(eatBoardId)
                .joinMember(toJoinMember(idpId))
                .build();
     }
    public JoinInfo toJoinInfo(Long joinInfo, String locationCategory){
        return JoinInfo.builder()
                .eatInfoWhenJoin(EpochTime.toLocalDateTime(joinInfo))
                .locationCategory(LocationCategory.hasCategory(locationCategory))
                .build();
    }

    public JoinMember toJoinMember(Long ipdId){
        return JoinMember.builder()
                .idpId(ipdId)
                .build();
    }
}
