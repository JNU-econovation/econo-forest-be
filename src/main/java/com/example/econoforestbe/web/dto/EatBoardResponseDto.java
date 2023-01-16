package com.example.econoforestbe.web.dto;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.util.EpochTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;


@Builder
@Getter
public class EatBoardResponseDto {

    private int page;
    private int lastPage;
    private EatPlan eatPlan;

    public static EatBoardResponseDto mapFrom(EatBoard eatBoard, int page, int lastPage, List<String> names){
        return EatBoardResponseDto.builder()
                .page(page)
                .lastPage(lastPage)
                .eatPlan(EatPlan.builder()
                        .eatBoardId(eatBoard.getId())
                        .title(eatBoard.getTitle().getTitle())
                        .eatInfo(EpochTime.toEpochSecond(eatBoard.getEatInfo().getEatDateTime()))
                                .location(eatBoard.getLocationCategory())
                                .numParticipant(eatBoard.getEatMembers().getEatMemberList().size())
                        .participants()
                                .build())
                .build();
    }
}
@Builder
@AllArgsConstructor
@Getter
class EatPlan{
    private Long eatBoardId;
    private String title;
    private Long eatInfo;
    private LocationCategory location;
    private int numParticipant;
    private Participants participants;
    private String authorName;
    private EatMemberType eatMemberType;
}
@Builder
@AllArgsConstructor
@Getter
class Participants{
    private Long clubYear;
    private String name;
}
