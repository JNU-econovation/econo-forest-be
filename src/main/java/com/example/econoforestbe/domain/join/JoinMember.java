package com.example.econoforestbe.domain.join;

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
}
