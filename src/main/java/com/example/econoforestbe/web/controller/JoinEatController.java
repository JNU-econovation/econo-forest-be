package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.global.config.response.ResponseDto;
import com.example.econoforestbe.global.config.response.ResponseGenerator;
import com.example.econoforestbe.global.config.response.success.SuccessCode;
import com.example.econoforestbe.global.config.response.success.SuccessResponse;
import com.example.econoforestbe.service.join.JoinEatService;
import com.example.econoforestbe.web.dto.JoinEatDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Api(tags = "밥 먹어요 글 참여/불참")
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/eatBoards/{eatBoardId}/participate")
public class JoinEatController {
    private final JoinEatService joinEatService;

    @ApiOperation(value="밥 먹어요 글 참여")
    @PostMapping("")
    public ResponseDto<SuccessResponse.successWithoutDataBody> participateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                                                   @Parameter(description = "글 UID", required = true, example = "1")
                                                                                   @PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.joinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseGenerator.success(SuccessCode.PARTICIPATE_EAT_BOARD.getHttpStatus(),
                SuccessCode.PARTICIPATE_EAT_BOARD.getErrorCode(),
                SuccessCode.PARTICIPATE_EAT_BOARD.getMessage());
    }
    @ApiOperation(value="밥 먹어요 글 불참")
    @DeleteMapping("")
    public ResponseDto<SuccessResponse.successWithoutDataBody> nonParticipateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                                                      @Parameter(description = "글 UID", required = true, example = "1")
                                                                                      @PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.nonJoinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseGenerator.success(SuccessCode.NON_PARTICIPATE_EAT_BOARD.getHttpStatus(),
                SuccessCode.NON_PARTICIPATE_EAT_BOARD.getErrorCode(),
                SuccessCode.NON_PARTICIPATE_EAT_BOARD.getMessage());
    }



}
