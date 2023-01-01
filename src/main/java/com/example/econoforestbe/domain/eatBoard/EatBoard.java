package com.example.econoforestbe.domain.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class EatBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "EAT_BOARD_ID")
    private Long id;
    @Embedded
    @Column(name = "EAT_BOARD_NAME")
    private Title title;
    @Enumerated(EnumType.STRING)
    @Column(name = "EAT_BOARD_LOCATION_CATEGORY")
    private LocationCategory locationCategory;
    @Embedded
    private EatInfo eatInfo;
    @Embedded
    private EatMembers eatMembers;

    private boolean isDeleted;

    public void delete() {
        this.isDeleted = true;
    }
}
