package com.example.econoforestbe.domain.eatToagther;

import lombok.NoArgsConstructor;

import javax.persistence.*;

@Embeddable
@NoArgsConstructor
public class EatTogatherInfo {

    @Embedded
    private EatTogatherDate eatTogatherDate;

    @Column(name = "eating_loation")
    @Enumerated(EnumType.STRING)
    private EatLocation eatLocation;

    public EatTogatherInfo(EatTogatherDate eatTogatherDate, EatLocation eatLocation) {
        this.eatTogatherDate = eatTogatherDate;
        this.eatLocation = eatLocation;
    }

}
