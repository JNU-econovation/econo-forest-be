package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.EatReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/eatBoard")
@Slf4j
public class EatBoardController {
    private final EatBoardService eatBoardService;

    @PostMapping("")
    public ResponseEntity<Object> createEatBoard(@RequestHeader(value = "Authorization") String accessToken, @RequestBody EatReqDto eatReqDto) {
        EatBoard newEatBoard = eatBoardService.createEatBoard(eatReqDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{boardId}")
                .buildAndExpand(newEatBoard.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .build();
    }

    @DeleteMapping("/{eatBoardId}")
    public void deleteEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId) {
        eatBoardService.deleteEatBoard(eatBoardId);
    }

    @PostMapping("/{eatBoardId}")
    public ResponseEntity<Object> updateEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId, @RequestBody EatReqDto eatReqDto) {
        EatBoard updateEatBoard = eatBoardService.updateEatBoard(eatBoardId, eatReqDto);
        log.info("게시글 수정 완료");
        URI uri=ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/eatBoard/{eatBoardId}")
                .buildAndExpand(updateEatBoard.getId())
                .toUri();
        log.info("uri 만들었습니다."+String.valueOf(uri));
        return ResponseEntity.created(uri)
                .build();
    }

}
