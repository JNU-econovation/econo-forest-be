package com.example.econoforestbe.infra.eatTogather;

import com.example.econoforestbe.domain.Member.Member;
import com.example.econoforestbe.domain.eatToagther.EatLocation;
import com.example.econoforestbe.domain.eatToagther.EatTogather;
import com.example.econoforestbe.domain.eatToagther.EatTogatherDate;
import com.example.econoforestbe.domain.eatToagther.EatTogatherInfo;
import com.example.econoforestbe.domain.eatToagther.spec.EatTogatherDateSpec;
import com.example.econoforestbe.domain.eatToagther.spec.LocationSpec;
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
import java.util.List;

@SpringBootTest
@Transactional
class JpaEatTogatherRepositoryTest {
    @PersistenceContext
    private EntityManager em;
    @Autowired
    private JpaEatTogatherRepository jpaEatTogatherRepository;

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
    }

    @Test
    void findByLocation() {
        Specification<EatTogather> locationSpec = new LocationSpec(EatLocation.FRONT);
        EatTogather eatTogather = jpaEatTogatherRepository.findByLocation(locationSpec);

        Assertions.assertThat(eatTogather.getId())
                .isEqualTo(3);
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
        EatTogatherDateSpec eatTogatherDateSpec = new EatTogatherDateSpec(LocalDateTime.now()
                .plusDays(1L));
        EatTogather eatTogather = jpaEatTogatherRepository.findByDate(eatTogatherDateSpec);
        Assertions.assertThat(eatTogather.getId())
                .isEqualTo(3);
    }

    @Test
    void findAllByDate() {
        EatTogatherDateSpec eatTogatherDateSpec = new EatTogatherDateSpec(LocalDateTime.now());
        List<EatTogather> eatTogatherDate = jpaEatTogatherRepository.findAllByDate(eatTogatherDateSpec);
        Assertions.assertThat(eatTogatherDate.size())
                .isEqualTo(2);
    }
}