package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.global.config.response.ResponseDto;
import com.example.econoforestbe.global.config.response.ResponseGenerator;
import com.example.econoforestbe.global.config.response.success.SuccessCode;
import com.example.econoforestbe.global.config.response.success.SuccessResponse;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.EatReqDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/eatBoard")
@Slf4j
public class EatBoardController {
    private final EatBoardService eatBoardService;

    @PostMapping("")
    public ResponseDto<SuccessResponse.successWithoutDataBody> createEatBoard(@RequestHeader(value = "Authorization") String accessToken, @RequestBody EatReqDto eatReqDto) {
        EatBoard newEatBoard = eatBoardService.createEatBoard(accessToken,eatReqDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{boardId}")
                .buildAndExpand(newEatBoard.getId())
                .toUri();
        HttpHeaders httpHeaders=new HttpHeaders();
        httpHeaders.setLocation(uri);

        return ResponseGenerator.create(SuccessCode.CREATED_EAT_BOARD.getHttpStatus(),
                SuccessCode.CREATED_EAT_BOARD.getErrorCode(),
                SuccessCode.CREATED_EAT_BOARD.getMessage(),
                httpHeaders);
    }

    @DeleteMapping("/{eatBoardId}")
    public ResponseDto<SuccessResponse.successWithoutDataBody> deleteEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId) {
        eatBoardService.deleteEatBoard(accessToken,eatBoardId);

        return ResponseGenerator.success(SuccessCode.EDIT_EAT_BOARD.getHttpStatus(),
                SuccessCode.EDIT_EAT_BOARD.getErrorCode(),
                SuccessCode.EDIT_EAT_BOARD.getMessage());
    }

    @PostMapping("/{eatBoardId}")
    public ResponseDto<SuccessResponse.successWithoutDataBody> updateEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId, @RequestBody EatReqDto eatReqDto) {
        Long updateEatBoardId = eatBoardService.updateEatBoard(accessToken, eatBoardId, eatReqDto);
        log.info("게시글 수정 완료");
        URI uri = ServletUriComponentsBuilder.fromCurrentContextPath()
                .path("api/eatBoard/{eatBoardId}")
                .buildAndExpand(updateEatBoardId)
                .toUri();
        log.info("uri 만들었습니다." + String.valueOf(uri));
        return ResponseGenerator.success(SuccessCode.EDIT_EAT_BOARD.getHttpStatus(),
                SuccessCode.EDIT_EAT_BOARD.getErrorCode(),
                SuccessCode.EDIT_EAT_BOARD.getMessage());
    }

//    @GetMapping("")
//    public ResponseEntity<List<EatBoardResponseDto>> getEatBoard(@RequestHeader(value = "Authorization") String accessToken,
//                                                                 @RequestParam Integer page,
//                                                                 @RequestParam Integer size) {
//        log.info("페이징 불러오기");
//        return ResponseEntity.ok()
//                        .body(eatBoardService.getEatBoard(accessToken,page,size));
//    }
}