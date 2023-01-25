package com.example.econoforestbe.web.dto;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.util.EpochTime;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;
import java.util.stream.Collectors;


@Builder
@Getter
public class EatBoardResponseDto {

    private int page;
    private int lastPage;
    private EatPlan eatPlan;

    public static EatBoardResponseDto mapFrom(EatBoard eatBoard, int page, int lastPage, List<IdpDetailResponseDto> idpDetailResponseDto,String type) {
        return EatBoardResponseDto.builder()
                .page(page)
                .lastPage(lastPage)
                .eatPlan(EatPlan.builder()
                        .eatBoardId(eatBoard.getId())
                        .title(eatBoard.getTitle().getTitle())
                        .eatInfo(EpochTime.toEpochSecond(eatBoard.getEatInfo().getEatDateTime()))
                        .location(eatBoard.getEatInfo().getLocationCategory())
                        .numParticipant(eatBoard.getEatMembers().getEatMemberList().size())
                        .authorName(idpDetailResponseDto.get(0).getName())
                        .eatMemberType(type)
                        .participants(Participants.builder()
                                .participants(idpDetailResponseDto.stream()
                                        .map(x->Participant.builder()
                                                .clubYear(x.getYear())
                                                .name(x.getName())
                                                .build())
                                        .collect(Collectors.toList()))
                                .build())

                        .build())
                .build();
    }
}

@Builder
@AllArgsConstructor
@Getter
class EatPlan {
    private Long eatBoardId;
    private String title;
    private Long eatInfo;
    private LocationCategory location;
    private int numParticipant;
    private String authorName;
    private String eatMemberType;
    private Participants participants;

}

@Builder
@AllArgsConstructor
@Getter
class Participant {
    private Long clubYear;
    private String name;
}
@Builder
@Getter
class Participants {
    private List<Participant> participants;
}

