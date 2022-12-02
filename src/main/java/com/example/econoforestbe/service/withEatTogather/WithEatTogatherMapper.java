package com.example.econoforestbe.service.withEatTogather;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogather;
import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherRepository;
import com.example.econoforestbe.domain.withEatTogather.WithEatTogather;
import com.example.econoforestbe.domain.withEatTogather.WithEatTogatherInfo;
import com.example.econoforestbe.domain.withEatTogather.WithEatTogatherMember;
import com.example.econoforestbe.web.dto.EatTogatherLineDTO;
import org.springframework.stereotype.Component;

@Component
public class WithEatTogatherMapper {

    private EatTogatherRepository eatTogatherRepository;

    public WithEatTogatherMapper(EatTogatherRepository eatTogatherRepository) {
        this.eatTogatherRepository = eatTogatherRepository;
    }

    public WithEatTogather mapFrom(EatTogatherLineDTO eatTogatherLineDTO) {
        EatTogather eatTogather = eatTogatherRepository.findById(eatTogatherLineDTO.getEatTogatherId())
                .orElseThrow(IllegalAccessError::new);

        return new WithEatTogather(eatTogather,
                new WithEatTogatherInfo(
                        eatTogatherLineDTO.getEatTogatherLineDTOInfo()
                                .getLocalDateTime(),
                        eatTogatherLineDTO.getEatTogatherLineDTOInfo()
                                .getLocation()),
                new WithEatTogatherMember(eatTogatherLineDTO.getMemberId()));
    }
}
