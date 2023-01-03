package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.web.dto.EatBoardResponseDto;
import com.example.econoforestbe.web.dto.SaveEatDto;
import com.example.econoforestbe.web.dto.UpdateEatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.awt.print.Pageable;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EatBoardService {
    private static final String NOT_FOUND_BOARD = "존재하지 않는 밥 먹어요 글입니다.";
    private final EatBoardRepository eatBoardRepository;
    private final EatBoardMapper eatBoardMapper;

    //TODO : idpId랑 연결
    public EatBoard createEatBoard(SaveEatDto saveEatDto) {
        EatBoard requestEatBoard = eatBoardMapper.mapFrom(saveEatDto);
        EatBoard savedEatBoard = eatBoardRepository.save(requestEatBoard);

        return savedEatBoard;
    }

    public boolean deleteEatBoard(Long eatBoardId) {
        EatBoard eatBoard = eatBoardRepository.findById(eatBoardId)
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_BOARD));

        boolean isWriter = eatBoard.getEatMembers().getWriter().equals(1L);
        if (isWriter) {
            eatBoardRepository.delete(eatBoard);
            log.info("deleteEatBoard : 밥 먹어요 게시글 삭제 완료");
            return true;
        }
        throw new IllegalArgumentException("작성자가 아니라서 삭제 권한 없습니다");
    }

    public boolean updateEatBoard(UpdateEatDto updateEatDto) {
        //TODO : access Token으로 삭제 접근 권한 확인
        EatBoard eatBoard = eatBoardRepository.findById(updateEatDto.getBoardId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_BOARD));

        eatBoard.update(updateEatDto.getTitle(), updateEatDto.getLocation(), updateEatDto.getDate());
        return true;
    }

}
