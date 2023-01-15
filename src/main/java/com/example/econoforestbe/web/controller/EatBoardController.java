package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.EatBoardResponseDto;
import com.example.econoforestbe.web.dto.EatReqDto;
import com.example.econoforestbe.web.dto.IdpResponseDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/eatBoard")
@Slf4j
public class EatBoardController {
    private final EatBoardService eatBoardService;

    @PostMapping("")
    public ResponseEntity<Object> createEatBoard(@RequestHeader(value = "Authorization") String accessToken, @RequestBody EatReqDto eatReqDto) {
        EatBoard newEatBoard = eatBoardService.createEatBoard(accessToken,eatReqDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{boardId}")
                .buildAndExpand(newEatBoard.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .build();
    }

    @DeleteMapping("/{eatBoardId}")
    public void deleteEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId) {
        eatBoardService.deleteEatBoard(accessToken,eatBoardId);
    }

    @PostMapping("/{eatBoardId}")
    public ResponseEntity<Object> updateEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId, @RequestBody EatReqDto eatReqDto) {
        EatBoard updateEatBoard = eatBoardService.updateEatBoard(accessToken, eatBoardId, eatReqDto);
        log.info("게시글 수정 완료");
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/eatBoard/{eatBoardId}")
                .buildAndExpand(updateEatBoard.getId())
                .toUri();
        log.info("uri 만들었습니다." + String.valueOf(uri));
        return ResponseEntity.created(uri)
                .build();
    }

//    @GetMapping("")
//    public ResponseEntity<List<EatBoardResponseDto>> getEatBoard(@RequestHeader(value = "Authorization") String accessToken,
//                                                                 @PageableDefault(direction = Sort.Direction.ASC)Pageable pageable) {
//        log.info("페이징 불러오기");
//        return ResponseEntity.ok()
//                        .body(eatBoardService.getEatBoard(pageable));
//
//    }
}