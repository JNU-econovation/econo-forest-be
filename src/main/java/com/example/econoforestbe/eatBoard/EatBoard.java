package com.example.econoforestbe.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EatBoard {
    @Id
    @GeneratedValue
    private Long id;
    @Embedded
    private Title title;
    @Enumerated(EnumType.STRING)
    private LocationCategory locationCategory;
    @Embedded
    private EatInfo eatDateTime;
    @Embedded
    private EatMembers eatMembers;
}
