package com.example.econoforestbe.service.withEatTogather;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogather;
import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherMember;
import com.example.econoforestbe.service.eatTogatherBoard.EatTogatherService;
import com.example.econoforestbe.web.dto.EatTogatherLineDTO;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;

import java.time.LocalDateTime;
import java.util.List;

@SpringBootTest
@Sql({"/schema.sql","/data.sql"})
class WitEatTogatherServiceTest {

    @Autowired
    private WitEatTogatherService witEatTogatherService;
    @Autowired
    private EatTogatherService eatTogatherService;

    @Test
    void joinEatTogather() {
        witEatTogatherService.joinEatTogather(new EatTogatherLineDTO(2L, 1L, new EatTogatherLineDTO.EatTogatherLineDTOInfo(LocalDateTime.of(2022, 12, 02, 0, 0, 0), "후문")));
        EatTogather eatTogather = eatTogatherService.readEatTogather(1L);
        List<EatTogatherMember> eatTogatherMemberList = eatTogather.getEatTogatherMembers()
                .getEatTogatherMemberList();
        Assertions.assertThat(eatTogatherMemberList.get(1).getId())
                .isEqualTo(2);
    }
}