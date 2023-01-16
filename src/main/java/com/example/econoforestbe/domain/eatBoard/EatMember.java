package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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
    @Enumerated(EnumType.STRING)
    private EatMemberType eatMemberType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatMember)) return false;
        EatMember eatMember = (EatMember) o;
        return eatMemberType == eatMember.eatMemberType && Objects.equals(idpId,eatMember.getIdpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpId, getWriter());
    }

    public Long getWriter(){
        if(this.eatMemberType.equals(EatMemberType.AUTHOR)){
            return this.idpId;
        }
        throw new IllegalArgumentException(NOT_FOUND_WRITER);
    }
}
