package com.example.econoforestbe.service.join;

import com.example.econoforestbe.domain.join.JoinEat;
import com.example.econoforestbe.domain.join.JoinValidator;
import com.example.econoforestbe.domain.join.JoinedEatEvent;
import com.example.econoforestbe.service.member.IdpFeignClient;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class JoinEatService {
    private final JoinEatMapper joinEatMapper;
    private final ApplicationEventPublisher publisher;
    private final JoinValidator joinValidator;
    private final IdpFeignClient idpFeignClient;

    /**
     *
     * @param accessToken
     * @param eatBoardId
     * @param joinEatDto : eatInfo, locationCategory
     */
    @Transactional
    public void joinEatTogather(String accessToken, Long eatBoardId, JoinEatDto joinEatDto) {
        Long idpId = idpFeignClient.getIdpId(accessToken).getId();
        JoinEat joinEat = joinEatMapper.mapFrom(idpId, eatBoardId, joinEatDto);
        joinValidator.validate(joinEat);
        publisher.publishEvent(new JoinedEatEvent(idpId, joinEat.getEatBoardId()));
    }
}

