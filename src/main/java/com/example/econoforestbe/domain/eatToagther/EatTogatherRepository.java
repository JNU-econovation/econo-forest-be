package com.example.econoforestbe.domain.eatToagther;

import org.springframework.data.jpa.domain.Specification;

import java.util.List;

public interface EatTogatherRepository {

    Long save(EatTogather eatTogather);

    EatTogather findById(Long id);

    EatTogather findByLocation(Specification<EatTogather> spec);

    List<EatTogather> findAllByLocation(Specification<EatTogather> spec);


    EatTogather findByDate(Specification<EatTogather> spec);

    List<EatTogather> findAllByDate(Specification<EatTogather> spec);


    EatTogather findBySpec(Specification<EatTogather> spec);

    List<EatTogather> findAllBySpec(Specification<EatTogather> spec);

    Boolean remove(Long id);

}
