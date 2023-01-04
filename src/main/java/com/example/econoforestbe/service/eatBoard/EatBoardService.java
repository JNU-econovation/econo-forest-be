package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.web.dto.EatReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EatBoardService {
    private static final String NOT_FOUND_BOARD = "존재하지 않는 밥 먹어요 글입니다.";
    private final EatBoardRepository eatBoardRepository;
    private final EatBoardMapper eatBoardMapper;

    //TODO : idpId랑 연결
    public EatBoard createEatBoard(EatReqDto eatReqDto) {
        EatBoard requestEatBoard = eatBoardMapper.mapFrom(eatReqDto);
        log.info("dto -> entity로 변환 완료");
        EatBoard savedEatBoard = eatBoardRepository.save(requestEatBoard);
        log.info("entity repo에 저장 완료");

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

    public EatBoard updateEatBoard(Long eatBoardId, EatReqDto eatReqDto) {
        deleteEatBoard(eatBoardId);
        log.info("updateEatBoard : 기존 밥 먹어요 게시글 삭제 완료");

        EatBoard updateEatBoard = createEatBoard(eatReqDto);
        log.info("updateEatBoard : 새로운 밥 먹어요 게시글 생성하여 글 수정 완료");
        return updateEatBoard;
    }

}
