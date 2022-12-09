package com.example.econoforestbe.eatBoard;

import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Embeddable
@NoArgsConstructor
public class EatMembers {
    private static final String DUPLICATE_MEMBER_IN_EAT = "이미 해당 밥먹어요에 참여한 사람입니다";
    private static final int WRITER_INDEX = 0;
    @OneToMany(cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<EatMember> eatMemberList = new ArrayList<>();

    public EatMember getWriter() {
        return eatMemberList.get(WRITER_INDEX)
                .getWriter();
    }

    public List<EatMember> addParticipant(EatMember eatMember) {
        eatMemberList.add(validateDuplicateMember(eatMember));
        return eatMemberList;
    }

    /**
     * 새로 참여하고자 하는 사람이 이미 참여한 사람인지 중복체크
     *
     * @param eatMember 새로 참여하고자 하는 사람
     */
    private EatMember validateDuplicateMember(EatMember eatMember) {
        return eatMemberList.stream()
                .filter(x -> x.isMember(eatMember))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(DUPLICATE_MEMBER_IN_EAT));
    }
}
