package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.domain.eatBoard.LocationCategory;
import com.example.econoforestbe.domain.join.JoinEat;
import com.example.econoforestbe.domain.join.JoinEatEvent;
import com.example.econoforestbe.domain.member.Member;
import com.example.econoforestbe.domain.member.MemberRepository;
import com.example.econoforestbe.web.dto.CreateEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.context.ApplicationEventPublisher;
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
    private static final String NOT_FOUND_MEMBER = "존재하지 않는 사용자입니다";
    private final EatBoardRepository eatBoardRepository;
    private final MemberRepository memberRepository;
    private final EatBoardMapper eatBoardMapper;

    //TODO : Access Token으로 요청으로 변경
    //TODO : response dto 변경
    public EatBoard createEatBoard(CreateEatDto createEatDto) {
        EatBoard eatBoard = eatBoardMapper.mapFrom(createEatDto);
        return eatBoard;
    }
}
