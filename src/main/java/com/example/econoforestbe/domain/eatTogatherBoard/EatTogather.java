package com.example.econoforestbe.domain.eatTogatherBoard;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Access(AccessType.FIELD)
@Table(name = "eat_togather")
public class EatTogather {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "eat_togather_id")
    private Long id;

    @Column(name = "eat_togather_titile")
    private String title;

    @Embedded
    private EatTogatherInfo eatTogatherInfo;

    private String writerId;

    @Embedded
    private EatTogatherMembers eatTogatherMembers;

    public EatTogather(String title, EatTogatherInfo eatTogatherInfo, String writerId, EatTogatherMembers eatTogatherMembers) {
        this.title = title;
        this.eatTogatherInfo = eatTogatherInfo;
        this.writerId = writerId;
        this.eatTogatherMembers = eatTogatherMembers;
    }

    public EatTogatherInfo getEatTogatherInfo() {
        return eatTogatherInfo;
    }

    public EatTogatherMembers getEatTogatherMembers() {
        return eatTogatherMembers;
    }
}
