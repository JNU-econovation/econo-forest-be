package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.util.EpochTime;
import com.example.econoforestbe.web.dto.EatBoardResponseDto;
import com.example.econoforestbe.web.dto.EatReqDto;
import org.springframework.stereotype.Component;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Component
public class EatBoardMapper {
    public EatBoard mapFrom(EatReqDto eatReqDto){
        return EatBoard.builder()
                .title(toTitle(eatReqDto.getTitle()))
                .locationCategory(LocationCategory.hasCategory(eatReqDto.getLocationCategory()))
                .eatMembers(toEatMembers(1L))
                .eatInfo(EatInfo.builder()
                        .eatDateTime(EpochTime.toLocalDateTime(eatReqDto.getEatDateTime()))
                        .build())
                .build();
    }

    //TODO : IDP Id 하드코딩 한 부분 변경
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
