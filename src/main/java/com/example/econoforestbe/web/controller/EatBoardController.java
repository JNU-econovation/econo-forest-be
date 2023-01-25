package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.global.config.response.ResponseDto;
import com.example.econoforestbe.global.config.response.ResponseGenerator;
import com.example.econoforestbe.global.config.response.success.SuccessCode;
import com.example.econoforestbe.global.config.response.success.SuccessResponse;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.EatReqDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@Api(tags = "밥 먹어요 CRUD")
@RestController
@RequiredArgsConstructor
@RequestMapping("api/eatBoards")
@Slf4j
public class EatBoardController {
    private final EatBoardService eatBoardService;

    @ApiOperation(value = "글 생성", notes = "밥 먹어요 글 생성합니다.")
    @ApiResponses(value={
            @ApiResponse(code=200,message = "글 생성 성공",response = ResponseDto.class)

    })
    @PostMapping("")
    public ResponseDto<SuccessResponse.successWithoutDataBody> createEatBoard(@RequestHeader(value = "Authorization") String accessToken, @RequestBody EatReqDto eatReqDto) {
        Long createEatBoardId = eatBoardService.createEatBoard(accessToken, eatReqDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{boardId}")
                .buildAndExpand(createEatBoardId)
                .toUri();
        HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setLocation(uri);

        return ResponseGenerator.create(SuccessCode.CREATED_EAT_BOARD.getHttpStatus(),
                SuccessCode.CREATED_EAT_BOARD.getErrorCode(),
                SuccessCode.CREATED_EAT_BOARD.getMessage(),
                httpHeaders);
    }

    @ApiOperation(value = "글 삭제", notes = "밥 먹어요 글 삭제합니다.")
    @DeleteMapping("/{eatBoardId}")
    public ResponseDto<SuccessResponse.successWithoutDataBody> deleteEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                                              @Parameter(description = "글 UID", required = true, example = "1") @PathVariable Long eatBoardId) {
        eatBoardService.deleteEatBoard(accessToken, eatBoardId);

        return ResponseGenerator.success(SuccessCode.EDIT_EAT_BOARD.getHttpStatus(),
                SuccessCode.EDIT_EAT_BOARD.getErrorCode(),
                SuccessCode.EDIT_EAT_BOARD.getMessage());
    }

    @ApiOperation(value = "글 수정", notes = "밥 먹어요 글 수정합니다.")
    @PostMapping("/{eatBoardId}")
    public ResponseDto<SuccessResponse.successWithoutDataBody> updateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                                              @Parameter(description = "글 UID", required = true, example = "1") @PathVariable Long eatBoardId, @RequestBody EatReqDto eatReqDto) {
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

//    @ApiOperation(value="밥 먹어요 글 페이징 조회")
//    @GetMapping("")
//    public ResponseEntity<List<EatBoardResponseDto>> getEatBoard(@RequestHeader(value = "Authorization") String accessToken,
//                                                                 @RequestParam Integer page,
//                                                                 @RequestParam Integer size) {
//        log.info("페이징 불러오기");
//        return ResponseEntity.ok()
//                        .body(eatBoardService.getEatBoard(accessToken,page,size));
//    }
}