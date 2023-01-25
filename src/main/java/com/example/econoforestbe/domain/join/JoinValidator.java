package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.*;
import com.example.econoforestbe.global.config.response.error.exception.common.NotFoundBoard;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinValidator {
    private final EatBoardRepository eatBoardRepository;

    public void validate(JoinEat joinEat) {
        EatBoard eatBoard=validateEatBoard(joinEat.getEatBoardId());
        validateJoinInfo(joinEat.getCompareInfoByJoin(), eatBoard.getEatInfo());
    }

    private EatBoard validateEatBoard(Long eatBoardId) {
        return eatBoardRepository.findById(eatBoardId)
                .orElseThrow(NotFoundBoard::new);
    }

    /**
     * 참가신청할 때 게시글의 정보가 현재 게시글의 정보와 일치하는지 검증
     *
     * @param joinInfo
     * @param eatInfo
     */
    private void validateJoinInfo(JoinInfo joinInfo, EatInfo eatInfo) {
        eatInfo.validateStatus(joinInfo.convertToInfo());
    }

}
