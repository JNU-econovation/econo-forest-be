package com.example.econoforestbe.service.eatBoard;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.domain.eatBoard.EatBoardRepository;
import com.example.econoforestbe.global.config.response.error.exception.common.NoDeleteRight;
import com.example.econoforestbe.global.config.response.error.exception.common.NotFoundBoard;
import com.example.econoforestbe.service.member.IdpFeignClient;
import com.example.econoforestbe.web.dto.EatBoardResponseDto;
import com.example.econoforestbe.web.dto.EatReqDto;
import com.example.econoforestbe.web.dto.IdpDetailResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
@Slf4j
public class EatBoardService {
    private final EatBoardRepository eatBoardRepository;
    private final EatBoardMapper eatBoardMapper;
    private final IdpFeignClient idpFeignClient;

    private Long idpId(String accessToken) {
        return idpFeignClient.getIdpId(accessToken).getId();
    }

    public Long createEatBoard(String accessToken, EatReqDto eatReqDto) {
        EatBoard requestEatBoard = eatBoardMapper.mapFrom(idpId(accessToken), eatReqDto);
        EatBoard savedEatBoard = eatBoardRepository.save(requestEatBoard);
        return savedEatBoard.getId();
    }

    public boolean deleteEatBoard(String accessToken, Long eatBoardId) {
        EatBoard eatBoard = eatBoardRepository.findById(eatBoardId)
                .orElseThrow(NotFoundBoard::new);

        boolean isWriter = eatBoard.getEatMembers().getWriter().equals(idpId(accessToken));
        if (isWriter) {
            eatBoardRepository.delete(eatBoard);
            log.info("deleteEatBoard : 밥 먹어요 게시글 삭제 완료");
            return true;
        }
        throw new NoDeleteRight();
    }

    //TODO : IDP 서버에 2번 요청하고 있음 -> 1번 요청 + 재활용 할 수 있는 방법 찾아보기
    public Long updateEatBoard(String accessToken,Long eatBoardId, EatReqDto eatReqDto) {
        deleteEatBoard(accessToken,eatBoardId);
        log.info("updateEatBoard : 기존 밥 먹어요 게시글 삭제 완료");

        Long updateEatBoardId = createEatBoard(accessToken,eatReqDto);
        log.info("updateEatBoard : 새로운 밥 먹어요 게시글 생성하여 글 수정 완료");
        return updateEatBoardId;
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

    public List<EatBoardResponseDto> getEatBoard(String accessToken,Integer page, Integer size) {
        Pageable paging= PageRequest.of(page,size);
        Page<EatBoard> pagingEatBoard = eatBoardRepository.findAll(paging);

        return pagingEatBoard.getContent()
                .stream().map(eatBoard -> EatBoardResponseDto.mapFrom(eatBoard,pagingEatBoard.getNumber(),pagingEatBoard.getTotalPages(),
                        idpNamesById(eatBoard),
                        getUserType(eatBoard.getId(),accessToken)))
                .collect(Collectors.toList());
    }

    private IdpDetailResponseDto idpNameById(Long idpId) {
        return idpFeignClient.getNamebyIdpId(idpId);
    }

    private List<IdpDetailResponseDto>idpNamesById(EatBoard eatBoard){
        return eatBoard.getEatMembers().getEatMemberList()
                .stream().map(eatMember -> idpNameById(eatMember.getIdpId()))
                .collect(Collectors.toList());

    }
    private String getUserType(Long eatBoardId, String accessToken){
        EatBoard eatBoard = eatBoardRepository.findById(eatBoardId)
                .orElseThrow(NotFoundBoard::new);
        Long idpId=idpId(accessToken);

        return eatBoard.getEatMembers().getType(idpId);

    }
}
