package com.example.econoforestbe.domain.eatTogatherBoard;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Objects;

@Embeddable
@NoArgsConstructor
public class EatTogatherMember {
    @Column(name = "eat_togather_member")
    private Long id;

    public EatTogatherMember(Long id) {
        this.id = id;
    }

    public EatTogatherMember(JoinMember joinMember) {
        this.id = joinMember.getMemberId();
    }

    public Long getId() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        if (!(o instanceof JoinMember)) return false;
        JoinMember other = (JoinMember) o;
        return Objects.equals(id, other.getMemberId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
