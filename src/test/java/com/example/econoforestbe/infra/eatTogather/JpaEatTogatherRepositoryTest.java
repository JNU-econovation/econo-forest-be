package com.example.econoforestbe.infra.eatTogather;

import com.example.econoforestbe.domain.Member.Member;
import com.example.econoforestbe.domain.eatToagther.*;
import com.example.econoforestbe.domain.eatToagther.spec.DateGreaterThanOrEqualSpec;
import com.example.econoforestbe.domain.eatToagther.spec.DateSpec;
import com.example.econoforestbe.domain.eatToagther.spec.LocationSpec;
import com.example.econoforestbe.infra.jpaspec.AndSpecification;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@SpringBootTest
@Transactional
class JpaEatTogatherRepositoryTest {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private JpaEatTogatherRepository jpaEatTogatherRepository;

    private Long eatTogather3Id;

    @BeforeEach
    public void initDataSet() {
        EatTogatherDate eatTogatherDateNow = new EatTogatherDate(LocalDateTime.now());
        EatTogatherDate eatTogatherDatePlusDate = new EatTogatherDate(LocalDateTime.now()
                .plusDays(1L));
        EatTogatherInfo eatTogatherInfoBack = new EatTogatherInfo(eatTogatherDateNow, EatLocation.BACK);
        EatTogatherInfo eatTogatherInfoFront = new EatTogatherInfo(eatTogatherDatePlusDate, EatLocation.FRONT);
        Member member = new Member();
        em.persist(member);

        EatTogather eatTogather1 = new EatTogather("test1", eatTogatherInfoBack, member);
        jpaEatTogatherRepository.save(eatTogather1);
        EatTogather eatTogather2 = new EatTogather("test2", eatTogatherInfoBack, member);
        jpaEatTogatherRepository.save(eatTogather2);
        EatTogather eatTogather3 = new EatTogather("test3", eatTogatherInfoFront, member);
        jpaEatTogatherRepository.save(eatTogather3);
        eatTogather3Id = eatTogather3.getId();
    }

    @Test
    void findByLocation() {
        Specification<EatTogather> locationSpec = new LocationSpec(EatLocation.FRONT);
        EatTogather eatTogather = jpaEatTogatherRepository.findByLocation(locationSpec);

        Assertions.assertThat(eatTogather.getId())
                .isEqualTo(eatTogather3Id);
    }

    @Test
    void findAllByLocation() {
        Specification<EatTogather> locationSpec = new LocationSpec(EatLocation.BACK);
        List<EatTogather> eatTogathers = jpaEatTogatherRepository.findAllByLocation(locationSpec);
        Assertions.assertThat(eatTogathers.size())
                .isEqualTo(2);
    }

    @Test
    void findByDate() {
        DateSpec dateSpec = new DateSpec(LocalDateTime.now()
                .plusDays(1L));
        EatTogather eatTogather = jpaEatTogatherRepository.findByDate(dateSpec);
        Assertions.assertThat(eatTogather.getId())
                .isEqualTo(eatTogather3Id);
    }

    @Test
    void findAllByDate() {
        DateSpec dateSpec = new DateSpec(LocalDateTime.now());
        List<EatTogather> eatTogatherDate = jpaEatTogatherRepository.findAllByDate(dateSpec);
        Assertions.assertThat(eatTogatherDate.size())
                .isEqualTo(2);
    }

    @Test
    void findAllByDateAfterToday() throws Exception {
        DateGreaterThanOrEqualSpec dateGreaterThanOrEqualSpec = new DateGreaterThanOrEqualSpec(LocalDateTime.now()
                .plusDays(1L));
        List<EatTogather> eatTogatherDate = jpaEatTogatherRepository.findAllByDate(dateGreaterThanOrEqualSpec);
        Assertions.assertThat(eatTogatherDate.size())
                .isEqualTo(1);

    }

    @Test
    void findAllByDateAnd() throws Exception {
        DateGreaterThanOrEqualSpec dateGreaterThanOrEqualSpec = new DateGreaterThanOrEqualSpec(LocalDateTime.now());
        LocationSpec locationSpec = new LocationSpec(EatLocation.FRONT);
        AndSpecification<EatTogather> eatTogatherAndSpecification = new AndSpecification<>(dateGreaterThanOrEqualSpec, locationSpec);
        List<EatTogather> eatTogatherDate = jpaEatTogatherRepository.findAllByDate(eatTogatherAndSpecification);
        Assertions.assertThat(eatTogatherDate.size())
                .isEqualTo(1);
    }
}