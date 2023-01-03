package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.util.EpochTime;
import com.example.econoforestbe.web.dto.SaveEatDto;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class EatBoardMapper {
    public EatBoard mapFrom(SaveEatDto saveEatDto){
        return EatBoard.builder()
                .title(toTitle(saveEatDto.getTitle()))
                .locationCategory(LocationCategory.hasCategory(saveEatDto.getLocationCategory()))
                .eatMembers(toEatMembers(1L))
                .eatInfo(EatInfo.builder()
                        .eatDateTime(EpochTime.toLocalDateTime(saveEatDto.getEatDateTime()))
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
