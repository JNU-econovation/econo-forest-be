package com.example.econoforestbe.domain.eatTogatherBoard;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Optional;

@Embeddable
@NoArgsConstructor
public class EatTogatherMembers {

    @ElementCollection(fetch = FetchType.LAZY)
    @CollectionTable(name = "eat_togatehr_members",
            joinColumns = @JoinColumn(name = "eat_togather_id"))
    @OrderColumn(name = "eat_togatehr_member_idx")
    private List<EatTogatherMember> eatTogatherMemberList;

    public EatTogatherMembers(Long memberId) {
        this.eatTogatherMemberList = List.of(new EatTogatherMember(memberId));
    }

    public List<EatTogatherMember> getEatTogatherMemberList() {
        return eatTogatherMemberList;
    }

    public Long getWriter() {
        return eatTogatherMemberList.get(0)
                .getId();
    }

    public void addEatTogatherMember(JoinMember joinMember) {
        EatTogatherMember eatTogatherMember = new EatTogatherMember(joinMember);
        validateJoinMember(eatTogatherMember);
        eatTogatherMemberList.add(eatTogatherMember);
    }

    private void validateJoinMember(EatTogatherMember eatTogatherMember) {
        isWriter(eatTogatherMember);
        isAlreadyInList(eatTogatherMember);
    }

    private boolean isWriter(EatTogatherMember eatTogatherMember) {
        if (eatTogatherMemberList.get(0).equals(eatTogatherMember)) {
            return true;
        }
        return false;
    }

    private void isAlreadyInList(EatTogatherMember eatTogatherMember) {
        Optional<EatTogatherMember> anyFoundResult = eatTogatherMemberList.stream()
                .filter(existMember -> existMember.equals(eatTogatherMember))
                .findAny();
        if (anyFoundResult.isPresent()) {
            throw new IllegalArgumentException("this member is already participated in this eatTogather meeting");
        }
    }
}
