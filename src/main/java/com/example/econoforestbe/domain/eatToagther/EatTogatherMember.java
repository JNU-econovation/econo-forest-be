package com.example.econoforestbe.domain.eatToagther;

import com.example.econoforestbe.domain.Member.Member;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
@NoArgsConstructor
public class EatTogatherMember {
    @Column(name = "eating_memberId")
    private Long memberId;

    public EatTogatherMember(Member member) {
        this.memberId = member.getId();
    }

    public boolean isEqualMember(Member member) {
        if (this.memberId == member.getId()) {
            return true;
        }
        return false;
    }
}
