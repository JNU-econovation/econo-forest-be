package com.example.econoforestbe.join;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.time.LocalDateTime;

@Entity
public class joinEat {
    @Id
    @GeneratedValue
    private Long id;
    private LocalDateTime joinDateTime;
    @Embedded
    private eatInfoByJoin compareInfoByJoin;

}
