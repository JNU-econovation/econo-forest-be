package com.example.econoforestbe.service.eatTogatherBoard;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogather;
import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherInfo;
import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherMembers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;

@SpringBootTest
@Sql({"/schema.sql","/data.sql"})
class EatTogatherServiceTest {

    @Autowired
    private EatTogatherService eatTogatherService;

    @Test
    void postEatTogather() {
        eatTogatherService.postEatTogather(new EatTogather("테스트2", new EatTogatherInfo(LocalDateTime.now(), "정문"), 1L, new EatTogatherMembers(2L)));
    }

    @Test
    void readEatTogather() {
        eatTogatherService.readEatTogather(1L);
    }
}