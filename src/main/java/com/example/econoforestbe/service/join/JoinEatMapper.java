package com.example.econoforestbe.service.join;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.domain.join.JoinEat;
import com.example.econoforestbe.domain.join.JoinInfo;
import com.example.econoforestbe.domain.join.JoinMember;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;


@Component
@RequiredArgsConstructor
public class JoinEatMapper {
    private static final String NOT_FOUND_EAT_BOARD = "존재하지 않은 밥먹어요 게시글 입니다";
    private final EatBoardRepository eatBoardRepository;

    public JoinEat mapFrom(JoinEatDto joinEatDto) {
        EatBoard eatBoard = eatBoardRepository.findById(joinEatDto.getEatBoardId())
                .orElseThrow(() -> new IllegalArgumentException(NOT_FOUND_EAT_BOARD));

        JoinInfo joinInfo = new JoinInfo(joinEatDto.getEatDateWhenJoin(), joinEatDto.getEatTimeWhenJoin());
        JoinMember joinMember = new JoinMember(joinEatDto.getJoinMemberId(), joinEatDto.isWriter());

        return JoinEat.builder()
                .compareInfoByJoin(joinInfo)
                .joinMember(joinMember)
                .build();
    }
}
