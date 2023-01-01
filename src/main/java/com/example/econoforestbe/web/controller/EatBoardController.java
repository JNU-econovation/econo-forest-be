package com.example.econoforestbe.web.controller;

import com.example.econoforestbe.domain.eatBoard.EatBoard;
import com.example.econoforestbe.service.eatBoard.EatBoardService;
import com.example.econoforestbe.web.dto.CreateEatDto;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;

@RestController
@RequiredArgsConstructor
@RequestMapping("api")
public class EatBoardController {
    private final EatBoardService eatBoardService;

    @PostMapping("/board")
    public ResponseEntity<EatBoard> createEatBoard(@RequestBody CreateEatDto createEatDto) {
        EatBoard newEatBoard = eatBoardService.createEatBoard(createEatDto);
        URI uri= ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{boardId}")
                .buildAndExpand(newEatBoard.getId())
                .toUri();
        return ResponseEntity.created(uri)
                .body(newEatBoard);

    }
}
