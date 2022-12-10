package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class EatBoardService {
    private static final String NOT_FOUND_EAT_BOARD="해당 하는 밥먹어요 글이 없습니다";

    private final EatBoardRepository eatBoardRepository;

    public EatBoard postEatBoard(EatBoard eatBoard) {
        return eatBoardRepository.save(eatBoard);
    }

    public EatBoard getEatBoard(Long eatBoardId) {
        Optional<EatBoard> eatBoard=eatBoardRepository.findById(eatBoardId);
        if (eatBoard.isEmpty()) {
            throw new IllegalArgumentException(NOT_FOUND_EAT_BOARD);
        }
        return eatBoard.get();
    }
    @Scheduled(cron = "0 0 0 * * *")
    public List<EatBoard> deleteByOverDate(){
        List<EatBoard> eatBoard=eatBoardRepository.findAll();
        return eatBoard.stream()
                .filter(x->x.getEatDateTime().overDate())
                .collect(Collectors.toList());
    }
}
