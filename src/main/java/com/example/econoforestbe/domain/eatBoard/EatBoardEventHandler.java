package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.domain.join.JoinedEatEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;
import org.springframework.transaction.NoTransactionException;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class EatBoardEventHandler {
    private static final String NOT_FOUND_EAT_BOARD="존재하지 않은 밥먹어요 게시판입니다";
    private final EatBoardRepository eatBoardRepository;

    @EventListener
    @Async
    @Transactional
    public void handler(JoinedEatEvent event) {
        EatBoard eatBoard = eatBoardRepository.findById(event.getEatBoardId())
                .orElseThrow(()->new IllegalArgumentException(NOT_FOUND_EAT_BOARD));

        EatParticipate eatParticipate=EatParticipate.builder()
                        .idpId(event.getIdpId())
                        .build();

        eatBoard.getEatMembers().addParticipant(toEatMember(event.getIdpId()));
    }

    private EatMember toEatMember(Long idpId){
        return EatMember.builder()
                .idpId(idpId)
                .eatMemberType(EatMemberType.PARTICIPANT)
                .build();
    }
}
