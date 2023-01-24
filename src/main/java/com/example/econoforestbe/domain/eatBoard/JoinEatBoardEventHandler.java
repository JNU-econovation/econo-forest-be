package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.domain.join.JoinedEatEvent;
import com.example.econoforestbe.domain.join.NonJoinedEatEvent;
import com.example.econoforestbe.global.config.response.error.exception.common.NOT_FOUND_BOARD;
import lombok.RequiredArgsConstructor;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;

@Component
@RequiredArgsConstructor
public class JoinEatBoardEventHandler {
    private final EatBoardRepository eatBoardRepository;

    @EventListener
    @Async
    @Transactional
    public void handler(JoinedEatEvent event) {
        EatBoard eatBoard = eatBoardRepository.findById(event.getEatBoardId())
                .orElseThrow(NOT_FOUND_BOARD::new);
        eatBoard.getEatMembers().addParticipant(toEatParticipate(event.getIdpId()));
    }
    private EatParticipate toEatParticipate(Long idpId){
        return EatParticipate.builder()
                .idpId(idpId)
                .build();
    }

}
