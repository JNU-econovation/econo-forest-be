package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.SaveEatDto;
import com.example.econoforestbe.web.dto.UpdateEatDto;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
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
    public ResponseEntity<EatBoard> createEatBoard(@RequestHeader(value = "Authorization") String accessToken, @Valid @RequestBody SaveEatDto saveEatDto) {
        EatBoard newEatBoard = eatBoardService.createEatBoard(saveEatDto);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{boardId}")
                .buildAndExpand(newEatBoard.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(newEatBoard);
    }

    @DeleteMapping("/{eatBoardId}")
    public void deleteEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId) {
        eatBoardService.deleteEatBoard(eatBoardId);
    }

    @PostMapping("/{eatBoardId}")
    public ResponseEntity<Object> updateEatBoard(@RequestHeader(value = "Authorization") String accessToken, @PathVariable Long eatBoardId, @RequestBody UpdateEatDto updateEatDto) {
        EatBoard updateEatBoard = eatBoardService.updateEatBoard(eatBoardId, updateEatDto);
        URI uri=ServletUriComponentsBuilder.fromCurrentRequestUri()
                .buildAndExpand(updateEatBoard.getId())
                .toUri();

        log.info(String.valueOf(uri));
        return ResponseEntity.created(uri)
                .build();
    }

}
