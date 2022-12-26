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
