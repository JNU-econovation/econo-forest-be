package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.util.EpochTime;
import com.example.econoforestbe.web.dto.EatReqDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EatBoardMapper {
    public EatBoard mapFrom(Long idpId, EatReqDto eatReqDto){
        return EatBoard.builder()
                .title(toTitle(eatReqDto.getTitle()))
                .eatMembers(toEatMembers(idpId))
                .eatInfo(EatInfo.builder()
                        .localDateTime(EpochTime.toLocalDateTime(eatReqDto.getEatDateTime()))
                        .locationCategory(LocationCategory.hasCategory(eatReqDto.getLocationCategory()))
                        .build())
                .build();
    }

    private EatMembers toEatMembers(Long idpId){
        return EatMembers.builder()
                .eatMemberList(eatMembers(idpId))
                .build();
    }

    private EatMember toEatMember(Long idpId){
        return EatMember.builder()
                .idpId(idpId)
                .eatMemberType(EatMemberType.AUTHOR)
                .build();
    }

    private List<EatMember>eatMembers(Long idpId){
        List<EatMember>memberList=new ArrayList<>();
        memberList.add(toEatMember(idpId));
        return memberList;
    }

    private Title toTitle(String title){
        return Title.builder()
                .title(title)
                .build();
    }
}
