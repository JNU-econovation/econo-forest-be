package com.example.econoforestbe.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatMember;
import com.example.econoforestbe.domain.eatBoard.EatParticipate;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class EatMemberTest {

    @Test
    void isMember() {
        EatMember eatMember=new EatMember(1L,2L,false);
        EatParticipate eatParticipate = new EatParticipate(2L,false);
        Assertions.assertThat(eatMember.isMember(eatParticipate)).isEqualTo(true);
    }
}