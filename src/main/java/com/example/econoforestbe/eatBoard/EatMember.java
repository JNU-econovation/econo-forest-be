package com.example.econoforestbe.eatBoard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
public class EatMember {
    @Id
    @GeneratedValue
    private Long id;
    private Long idpId;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatMember)) return false;
        EatMember eatMember = (EatMember) o;
        return idpId.equals(eatMember.idpId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpId);
    }

    public boolean isSatisfiedBy(EatParticipate eatParticipate) {
        return Objects.equals(idpId,eatParticipate.getIdpId());
    }
}
