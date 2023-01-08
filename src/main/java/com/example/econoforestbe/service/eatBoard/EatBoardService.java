package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.web.dto.EatBoardResponseDto;
import com.example.econoforestbe.web.dto.EatReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.PageRequest;
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
@Slf4j
public class EatBoardService {
    private static final String NOT_FOUND_BOARD = "존재하지 않는 밥 먹어요 글입니다.";
    private final EatBoardRepository eatBoardRepository;
    private final EatBoardMapper eatBoardMapper;

    //TODO : idpId랑 연결
    public EatBoard createEatBoard(EatReqDto eatReqDto) {
        EatBoard requestEatBoard = eatBoardMapper.mapFrom(eatReqDto);
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

    public EatBoard updateEatBoard(Long eatBoardId, EatReqDto eatReqDto) {
        deleteEatBoard(eatBoardId);
        log.info("updateEatBoard : 기존 밥 먹어요 게시글 삭제 완료");

        EatBoard updateEatBoard = createEatBoard(eatReqDto);
        log.info("updateEatBoard : 새로운 밥 먹어요 게시글 생성하여 글 수정 완료");
        return updateEatBoard;
    }

    @Scheduled(cron = "0 0 0 * * *", zone = "Asia/Seoul")
    public void deleteEatBoardByAuto() {
        log.info("deleteEatBoardByAuto : 실행");
        List<EatBoard> eatBoardList = eatBoardRepository.findAll()
                .stream().filter(eatBoard -> eatBoard.getEatInfo().isBefore())
                .collect(Collectors.toList());
        log.info(String.valueOf(eatBoardList.size()));

        if (eatBoardList.size() != 0) {
            eatBoardRepository.deleteAll(eatBoardList);
            log.info("deleteEatBoardByAuto : 스케줄링으로 시간이 지난 거 자동 삭제 완료");
        }
        log.info(String.valueOf(eatBoardList.size()));
    }

    public List<EatBoardResponseDto> getEatBoard(Pageable pageable) {
        log.info("서비스 단에서 dto로 변경하여 전송");
        return eatBoardRepository.findAll(pageable).getContent()
                .stream().map(EatBoardResponseDto::mapFrom)
                .collect(Collectors.toList());
    }

}
