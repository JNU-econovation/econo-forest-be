package com.example.econoforestbe.eatBoard;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class EatMember {
    @Id
    @GeneratedValue
    private Long id;
    private Long idpId;
}
