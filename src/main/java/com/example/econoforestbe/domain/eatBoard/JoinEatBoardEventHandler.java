package com.example.econoforestbe.domain.eatBoard;

import com.example.econoforestbe.domain.join.JoinedEatEvent;
import com.example.econoforestbe.global.config.response.error.exception.common.NotFoundBoard;
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
                .orElseThrow(NotFoundBoard::new);
        eatBoard.getEatMembers().addParticipant(event.getEatBoardId());
    }

}
