package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
public class EatMember {
    private static final String NOT_FOUND_WRITER="작성자가 존재하지 않습니다";
    @Id
    @GeneratedValue()
    private Long id;

    private Long idpId;
    private boolean isWriter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatParticipate)) return false;
        EatParticipate eatParticipate = (EatParticipate) o;
        return isWriter == eatParticipate.isWriter() && Objects.equals(idpId, eatParticipate.getIdpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpId, getWriter());
    }

    public EatMember getWriter(){
        if(this.isWriter){
            return this;
        }
        throw new IllegalArgumentException(NOT_FOUND_WRITER);
    }
}
