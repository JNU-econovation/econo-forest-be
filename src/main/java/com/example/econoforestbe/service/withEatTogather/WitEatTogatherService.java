package com.example.econoforestbe.service.withEatTogather;

import com.example.econoforestbe.domain.withEatTogather.WithEatTogather;
import com.example.econoforestbe.web.dto.EatTogatherLineDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class WitEatTogatherService {
    private final WithEatTogatherMapper withEatTogatherMapper;

    @Transactional
    public void joinEatTogather(EatTogatherLineDTO eatTogatherLineDTO) {
        WithEatTogather withEatTogather = withEatTogatherMapper.mapFrom(eatTogatherLineDTO);
        withEatTogather.participate();
    }

}
