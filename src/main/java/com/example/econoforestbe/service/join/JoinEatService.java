package com.example.econoforestbe.service.join;

import com.example.econoforestbe.domain.join.JoinEat;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class JoinEatService {
    private final JoinEatMapper joinEatMapper;

    @Transactional
    public boolean joinEatTogather(JoinEatDto joinEatDto) {
        JoinEat joinEat = joinEatMapper.mapFrom(joinEatDto);
        return joinEat.joinEatBoard();
    }

}
