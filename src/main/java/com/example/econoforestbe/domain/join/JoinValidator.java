package com.example.econoforestbe.domain.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.domain.eatBoard.EatInfo;
import com.example.econoforestbe.domain.eatBoard.EatMembers;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class JoinValidator {

    private static final String NOT_FOUDN_EAT_BOARD="존재하지 않은 밥 먹어요 게시글 입니다.";
    private final EatBoardRepository eatBoardRepository;

    public void validate(JoinEat joinEat) {
        EatBoard eatBoard = eatBoardRepository.findById(joinEat.getEatBoardId())
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUDN_EAT_BOARD));

        validateJoinInfo(joinEat.getCompareInfoByJoin(),eatBoard.getEatInfo());
    }

    /**
     * 참가신청할 때 게시글의 정보가 현재 게시글의 정보와 일치하는지 검증
     * @param joinInfo
     * @param eatInfo
     */
    private void validateJoinInfo(JoinInfo joinInfo,EatInfo eatInfo){
        eatInfo.validateStatus(joinInfo.convertToInfo());
    }

}
