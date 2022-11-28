package com.example.econoforestbe.domain.eatToagther.spec;

import com.example.econoforestbe.domain.eatToagther.EatLocation;
import com.example.econoforestbe.domain.eatToagther.EatTogather;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import com.example.econoforestbe.domain.eatToagther.EatTogatherInfo_;
import com.example.econoforestbe.domain.eatToagther.EatTogather_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaQuery;

public class LocationSpec implements Specification<EatTogather> {

    private final EatLocation eatLocation;

    public LocationSpec(EatLocation eatLocation) {
        this.eatLocation = eatLocation;
    }

    @Override
    public Predicate toPredicate(Root<EatTogather> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.equal(root.get(EatTogather_.eatTogatherInfo)
                .get(EatTogatherInfo_.eatLocation), this.eatLocation);
    }

}

