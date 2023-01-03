package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.web.dto.EatBoardResponseDto;
import com.example.econoforestbe.web.dto.SaveEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
public class EatBoardService {
    private static final String NOT_FOUND_BOARD = "존재하지 않는 밥 먹어요 글입니다.";
    private final EatBoardRepository eatBoardRepository;
    private final EatBoardMapper eatBoardMapper;

    public EatBoard createEatBoard(SaveEatDto saveEatDto) {
        EatBoard requestEatBoard = eatBoardMapper.mapFrom(saveEatDto);
        EatBoard savedEatBoard = eatBoardRepository.save(requestEatBoard);

        return savedEatBoard;
    }

    //TODO : Access Token으로 요청으로 변경
    public void deleteEatBoard(Long idpId, Long eatBoardId) {
        EatBoard eatBoard = eatBoardRepository.findById(eatBoardId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_BOARD));

        boolean isWriter = eatBoard.getEatMembers().getWriter().equals(idpId);
        if (isWriter) {
            eatBoardRepository.delete(eatBoard);
        }
    }

//    public Page<EatBoard> getEatBoard(Pageable pageable) {
//        return eatBoardRepository.findAll(pageable)
//                .map()
//
//    }
}
