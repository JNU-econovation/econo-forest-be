package com.example.econoforestbe.domain.eatToagther;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.DateTimeException;
import java.time.LocalDateTime;

class EatTogatherDateTest {

    @Test
    void 생성() {
        EatTogatherDate eatTogatherDate = new EatTogatherDate(LocalDateTime.now());
    }

    @Test
    void 오늘_이전의_날짜로_기록() throws Exception {
        //given
        LocalDateTime today = LocalDateTime.now();
        LocalDateTime exceptionDate = today.minusDays(1L);

        //when

        //then
        Assertions.assertThatExceptionOfType(DateTimeException.class)
                .isThrownBy(() -> new EatTogatherDate(exceptionDate));
    }
}