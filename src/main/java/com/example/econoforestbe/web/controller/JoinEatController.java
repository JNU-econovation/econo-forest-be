package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.service.join.JoinEatService;
import com.example.econoforestbe.web.dto.JoinEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/api/eatBoard")
public class JoinEatController {
    private final JoinEatService joinEatService;


    @PostMapping("/{eatBoardId}/participate")
    public ResponseEntity<String> participateEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId, @RequestBody JoinEatDto joinEatDto){
        joinEatService.joinEatTogather(accessToken,eatBoardId,joinEatDto);
        return ResponseEntity.ok()
                .body("참여완료");
    }


}
