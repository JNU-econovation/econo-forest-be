package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.domain.member.Member;
import com.example.econoforestbe.web.dto.CreateEatDto;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

@Component
//TODO : createEatDto idpId -> AccessToken으로 변경
public class EatBoardMapper {
    public EatBoard mapFrom(CreateEatDto createEatDto){
        return EatBoard.builder()
                .title(toTitle(createEatDto.getTitle()))
                .locationCategory(LocationCategory.hasCategory(createEatDto.getLocationCategory()))
                .eatInfo(toEatInfo(createEatDto.getEatDate(),createEatDto.getEatTime()))
                .eatMembers(toEatMembers(createEatDto.getEatMemberId()))
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
                .isWriter(true)
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

    private EatInfo toEatInfo(LocalDate eatDate, LocalTime eatTime){
        return EatInfo.builder()
                .eatDate(eatDate)
                .eatTime(eatTime)
                .build();
    }
}
