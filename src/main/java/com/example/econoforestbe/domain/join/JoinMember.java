package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatParticipate;

import javax.persistence.Embeddable;

@Embeddable
public class JoinMember {
    private Long idpId;
    private boolean isWriter;

    public EatParticipate convertToEatParticipate() {
        return new EatParticipate(idpId,isWriter);
    }
}