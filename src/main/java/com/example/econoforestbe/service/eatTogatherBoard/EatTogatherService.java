package com.example.econoforestbe.service.eatTogatherBoard;

import com.example.econoforestbe.domain.eatTogatherBoard.EatTogather;
import com.example.econoforestbe.domain.eatTogatherBoard.EatTogatherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class EatTogatherService {

    private final EatTogatherRepository eatTogatherRepository;

    @Transactional
    public void postEatTogather(EatTogather eatTogather) {
        eatTogatherRepository.save(eatTogather);
    }

    public EatTogather readEatTogather(Long eatTogatherId) {
        Optional<EatTogather> byIdEatTogather = eatTogatherRepository.findById(eatTogatherId);
        if (byIdEatTogather.isEmpty()) {
            throw new IllegalArgumentException("there are no eatTogather record");
        }
        return byIdEatTogather.get();
    }
}
