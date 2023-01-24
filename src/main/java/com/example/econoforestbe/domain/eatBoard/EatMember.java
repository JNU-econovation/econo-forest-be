package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.global.config.response.error.exception.common.NotFoundWriter;
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
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long idpId;
    @Enumerated(EnumType.STRING)
    private EatMemberType eatMemberType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof EatParticipate)) return false;
        EatParticipate eatParticipate = (EatParticipate) o;
        return idpId.equals(eatParticipate.getIdpId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(idpId);
    }

    public Long getWriter(){
        if(this.eatMemberType.equals(EatMemberType.AUTHOR)){
            return this.idpId;
        }
        throw new NotFoundWriter();
    }
}
