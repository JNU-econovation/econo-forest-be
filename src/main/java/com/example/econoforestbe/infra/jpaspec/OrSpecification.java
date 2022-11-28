package com.example.econoforestbe.infra.jpaspec;

import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.Arrays;
import java.util.List;

public class OrSpecification<T> implements Specification<T> {

    private List<Specification<T>> specs;

    public OrSpecification (Specification<T> ...specs) {
        this.specs = Arrays.asList(specs);
    }

    @Override
    public Predicate toPredicate(Root<T> root, CriteriaQuery<?> query, CriteriaBuilder criteriaBuilder) {
        Predicate[] predicates = specs.stream()
                .map(spec -> spec.toPredicate(root, query, criteriaBuilder))
                .toArray(Predicate[]::new);
        return criteriaBuilder.or(predicates);
    }
}

