package com.example.econoforestbe.domain.eatTogatherBoard;

import com.example.econoforestbe.domain.EatLocation;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Access(AccessType.FIELD)
public class EatTogatherBoard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;

    private LocalDateTime dateTime;

    @Enumerated(EnumType.STRING)
    private EatLocation location;

    private String writerId;

    @Embedded
    private EatTogatherMembers eatTogatherMembers;

}
