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
            joinColumns = @JoinColumn(name = "id"))
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

    public void addEatTogatherMember(Long memberId) {
        EatTogatherMember eatTogatherMember = new EatTogatherMember(memberId);
        isAlreadyInList(eatTogatherMember);
        eatTogatherMemberList.add(eatTogatherMember);
    }

    private void isAlreadyInList(EatTogatherMember eatTogatherMember) {
        Optional<EatTogatherMember> anyFoundResult = eatTogatherMemberList.stream()
                .filter(members -> members.equals(eatTogatherMember))
                .findAny();
        if (anyFoundResult.isPresent()) {
            throw new IllegalArgumentException("this member is already participated in this eatTogather meeting");
        }
    }

    public boolean isWriter(Long memberid) {
        if (eatTogatherMemberList.get(0)
                .getId() == memberid) {
            return true;
        }
        return false;
    }
}
