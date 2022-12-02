package com.example.econoforestbe.domain.eatTogatherBoard;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Access(AccessType.FIELD)
public class EatTogather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    @Embedded
    private EatTogatherInfo eatTogatherInfo;

    private String writerId;

    @Embedded
    private EatTogatherMembers eatTogatherMembers;

    public EatTogather( String title, EatTogatherInfo eatTogatherInfo, String writerId, EatTogatherMembers eatTogatherMembers) {
        this.title = title;
        this.eatTogatherInfo = eatTogatherInfo;
        this.writerId = writerId;
        this.eatTogatherMembers = eatTogatherMembers;
    }
}
