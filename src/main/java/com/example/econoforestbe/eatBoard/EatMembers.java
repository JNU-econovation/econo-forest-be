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
    private static final String DUPLICATE_MEMBER_IN_EAT="이미 해당 밥먹어요에 참여한 사람입니다";
    @OneToMany(cascade = CascadeType.PERSIST,orphanRemoval = true)
    private List<EatMember> eatMemberList=new ArrayList<>();
}
