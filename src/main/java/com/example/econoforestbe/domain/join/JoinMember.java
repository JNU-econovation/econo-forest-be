package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatParticipate;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class JoinMember {
    private Long idpId;

    public EatParticipate convertToEatParticipate() {
        return new EatParticipate(idpId);
    }
}
