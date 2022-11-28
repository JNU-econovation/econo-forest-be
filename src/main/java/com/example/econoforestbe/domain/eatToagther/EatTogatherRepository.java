package com.example.econoforestbe.domain.eatToagther;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface EatTogatherRepository {

    Long save(EatTogather eatTogather);

    EatTogather findById(Long id);

    EatTogather findBySpec(Specification<EatTogather> spec);

    List<EatTogather> findAllBySpec(Specification<EatTogather> spec);

    Boolean remove(Long id);

}
