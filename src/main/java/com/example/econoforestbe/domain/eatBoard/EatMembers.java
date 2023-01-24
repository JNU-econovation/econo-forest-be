package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Getter
public class EatMembers {
    private static final String DUPLICATE_MEMBER_IN_EAT = "이미 해당 밥먹어요에 참여한 사람입니다";
    private static final String NOT_PARTICIPATE_MEMBER_IN_EAT = "밥 먹어요에 참여하지 않은 사람입니다.";
    private static final int WRITER_INDEX = 0;
    @Builder.Default
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EatMember> eatMemberList = new ArrayList<>();

    public Long getWriter() {
        return eatMemberList.get(WRITER_INDEX)
                .getWriter();

    }

    /**
     *
     * @param eatParticipate 참여하고자 하는 사람
     * @return 해당 글의 참여자들 목록
     */
    public List<EatMember> addParticipant(EatParticipate eatParticipate) {
        validateDuplicateMember(eatParticipate);
        eatMemberList.add(toEatMember(eatParticipate));
        return eatMemberList;
    }
    private EatMember toEatMember(EatParticipate eatParticipate){
        return EatMember.builder()
                .idpId(eatParticipate.getIdpId())
                .eatMemberType(EatMemberType.PARTICIPANT)
                .build();
    }

    /**
     *
     * @param eatParticipate 참여하고자 하는 사람
     * 이미 해당 밥 먹어요에 참여한 사람이면 예외발생
     */
    private void validateDuplicateMember(EatParticipate eatParticipate) {
        eatMemberList.stream()
                .filter(eatMember -> eatMember.equals(eatParticipate))
                .findAny()
                .ifPresent(eatMember1 -> {
                    throw new IllegalArgumentException(DUPLICATE_MEMBER_IN_EAT);
                });
    }

    /**
     *
     * @param eatParticipate 불참하고자 하는 사람
     * @return 해당 불참자를 제외한 참여자들 목록
     */
    public List<EatMember> deleteParticipant(EatParticipate eatParticipate) {
        validateNotParticipate(eatParticipate);
        eatMemberList.remove(toEatMember(eatParticipate));
        return eatMemberList;
    }


    /**
     *
     * @param eatParticipate eatParticiate 불참하고자 하는 사람
     * 이전에 해당 밥 먹어요에 참여하지 않은 사람이라면 예외발생
     */
    private void validateNotParticipate(EatParticipate eatParticipate){
        eatMemberList.stream()
                .filter(participateMember -> eatParticipate.equals(participateMember))
                .findAny()
                .orElseThrow(()->new IllegalArgumentException(NOT_PARTICIPATE_MEMBER_IN_EAT));
    }
}
