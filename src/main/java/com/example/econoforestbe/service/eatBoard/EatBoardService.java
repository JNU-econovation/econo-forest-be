package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
        return eatBoardRepository.findById(eatBoardId)
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_EAT_BOARD));
    }

    public Page<EatBoard> getEatBoardWithLocation(LocationCategory locationCategory, Pageable pageable) {
        return eatBoardRepository.findByLocationCategory(locationCategory,pageable);
    }

}
