package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.SaveEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class EatBoardController {
    private final EatBoardService eatBoardService;

    @PostMapping("/board")
    public ResponseEntity<EatBoard> createEatBoard(@RequestHeader(value = "Authorization")String accessToken, @RequestBody SaveEatDto saveEatDto) {
        EatBoard newEatBoard = eatBoardService.createEatBoard(saveEatDto);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{boardId}")
                .buildAndExpand(newEatBoard.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(newEatBoard);
    }

    @DeleteMapping("/board/{eatBoardId}")
    public void deleteEatBoard(@RequestHeader(value = "Authorization")String accessToken, @PathVariable Long eatBoardId){
        eatBoardService.deleteEatBoard(eatBoardId);
    }

}
