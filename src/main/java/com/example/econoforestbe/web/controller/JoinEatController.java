package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.service.join.JoinEatService;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/eatBoard/{eatBoardId}/participate")
public class JoinEatController {
    private final JoinEatService joinEatService;


    @PostMapping("")
    public ResponseEntity<String> participateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                      @PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.joinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseEntity.ok()
                .body("참여완료");
    }

    @DeleteMapping("")
    public ResponseEntity<String> nonParticipateEatBoard(@RequestHeader(value = "Authorization") String accessToken,
                                                         3@PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.nonJoinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseEntity.ok()
                .body("미참으로 변경완료");
    }



}
