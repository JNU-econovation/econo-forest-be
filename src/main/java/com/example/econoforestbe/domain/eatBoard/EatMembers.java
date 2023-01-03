package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
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
public class EatMembers {
    private static final String DUPLICATE_MEMBER_IN_EAT = "이미 해당 밥먹어요에 참여한 사람입니다";
    private static final int WRITER_INDEX = 0;
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EatMember> eatMemberList = new ArrayList<>();

    public Long getWriter() {
        return eatMemberList.get(WRITER_INDEX)
                .getWriter();

    }

    /**
     *
     * @param eatMember 참여하고자 하는 사람
     * @return 해당 글의 참여자들 목록
     */
    public List<EatMember> addParticipant(EatMember eatMember) {
        validateDuplicateMember(eatMember);
        eatMemberList.add(eatMember);
        return eatMemberList;
    }

    /**
     *
     * @param eatMember 참여하고자 하는 사람
     * @return 중복되지 않은 사람이라면 EatMemeber 리턴
     */
    private void validateDuplicateMember(EatMember eatMember) {
        eatMemberList.stream()
                .filter(member -> member.equals(eatMember))
                .findAny()
                .ifPresent(eatMember1 -> {
                    throw new IllegalArgumentException(DUPLICATE_MEMBER_IN_EAT);
                });
    }
}
