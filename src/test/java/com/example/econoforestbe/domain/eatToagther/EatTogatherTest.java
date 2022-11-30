package com.example.econoforestbe.domain.eatToagther;

import com.example.econoforestbe.domain.Member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.time.LocalDateTime;


@DataJpaTest
@Transactional
class EatTogatherTest {

    @PersistenceContext
    EntityManager em;

    Member writer;
    EatTogather eatTogather;

    @BeforeEach
    public void init() {
        writer = new Member();
        EatTogatherDate eatTogatherDate = new EatTogatherDate(LocalDateTime.now());
        EatTogatherInfo eatTogatherInfo = new EatTogatherInfo(eatTogatherDate, EatLocation.BACK);
        eatTogather = new EatTogather("test1", eatTogatherInfo, writer);
    }

    @Test
    void 작성자_확인() throws Exception {
        //given

        //when
        boolean isWriter = eatTogather.isWriter(writer);

        //then
        Assertions.assertThat(isWriter)
                .isTrue();
    }

    @Test
    void 밥먹어요_참여() throws Exception {
        //given
        em.persist(writer);
        Member participateMember = new Member();
        em.persist(participateMember);

        //when
        eatTogather.participateEatTogather(participateMember);

        //then
        Assertions.assertThat(eatTogather.participateEatTogatherMemberCount())
                .isEqualTo(2);
    }

    @Test
    void 밥먹어요_취소() throws Exception {
        //given
        em.persist(writer);
        Member participateMember = new Member();
        em.persist(participateMember);
        eatTogather.participateEatTogather(participateMember);

        //when
        eatTogather.cancleEatTogather(participateMember);

        //then
        Assertions.assertThat(eatTogather.participateEatTogatherMemberCount())
                .isEqualTo(1);

    }

    @Test
    void 밥먹어요_취소_예외_작성자() throws Exception {
        //given
        em.persist(writer);
        Member participateMember = new Member();
        em.persist(participateMember);
        eatTogather.participateEatTogather(participateMember);

        //when


        //then
        Assertions.assertThatIllegalArgumentException()
                .isThrownBy(() -> eatTogather.cancleEatTogather(writer));

    }
}