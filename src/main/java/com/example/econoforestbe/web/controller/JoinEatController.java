package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.global.config.response.ResponseDto;
import com.example.econoforestbe.global.config.response.ResponseGenerator;
import com.example.econoforestbe.global.config.response.success.SuccessCode;
import com.example.econoforestbe.global.config.response.success.SuccessResponse;
import com.example.econoforestbe.service.join.JoinEatService;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/eatBoard/{eatBoardId}/participate")
public class JoinEatController {
    private final JoinEatService joinEatService;


    @PostMapping("")
    public ResponseDto<SuccessResponse.successWithoutDataBody> participateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                                                   @PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.joinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseGenerator.success(SuccessCode.PARTICIPATE_EAT_BOARD.getHttpStatus(),
                SuccessCode.PARTICIPATE_EAT_BOARD.getErrorCode(),
                SuccessCode.PARTICIPATE_EAT_BOARD.getMessage());
    }

    @DeleteMapping("")
    public ResponseDto<SuccessResponse.successWithoutDataBody> nonParticipateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                                                      @PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.nonJoinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseGenerator.success(SuccessCode.NON_PARTICIPATE_EAT_BOARD.getHttpStatus(),
                SuccessCode.NON_PARTICIPATE_EAT_BOARD.getErrorCode(),
                SuccessCode.NON_PARTICIPATE_EAT_BOARD.getMessage());
    }



}
