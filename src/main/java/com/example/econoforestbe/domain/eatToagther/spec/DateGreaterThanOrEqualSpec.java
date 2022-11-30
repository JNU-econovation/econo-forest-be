package com.example.econoforestbe.domain.eatToagther.spec;

import com.example.econoforestbe.domain.eatToagther.EatTogather;
import com.example.econoforestbe.domain.eatToagther.EatTogatherInfo_;
import com.example.econoforestbe.domain.eatToagther.EatTogather_;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class DateGreaterThanOrEqualSpec implements Specification<EatTogather> {
    private LocalDate date;

    public DateGreaterThanOrEqualSpec(LocalDateTime localDateTime) {
        this.date = localDateTime.toLocalDate();
    }

    @Override
    public Predicate toPredicate(Root<EatTogather> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        return criteriaBuilder.greaterThanOrEqualTo(root.get(EatTogather_.eatTogatherInfo)
                .get(EatTogatherInfo_.eatTogatherDate)
                .get("date"), date);
    }
}
