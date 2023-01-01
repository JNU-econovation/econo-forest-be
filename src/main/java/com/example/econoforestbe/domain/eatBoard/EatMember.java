package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class EatMember {
    private static final String NOT_FOUND_WRITER="작성자가 존재하지 않습니다";

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idpId;
    private boolean isWriter;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatMember)) return false;
        EatMember eatMember = (EatMember) o;
        return isWriter == eatMember.isWriter && Objects.equals(idpId,eatMember.getIdpId());
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
