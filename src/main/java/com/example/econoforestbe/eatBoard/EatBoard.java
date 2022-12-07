package com.example.econoforestbe.eatBoard;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

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
}
