package com.example.econoforestbe.join;

import com.example.econoforestbe.eatBoard.EatParticipate;

import javax.persistence.Embeddable;

@Embeddable
public class JoinMember {
    private Long idpId;

    public EatParticipate convertToEatParticipate() {
        return new EatParticipate(idpId);
    }
}
