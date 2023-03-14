package com.qrmaster.api.controller;

import com.qrmaster.api.dto.MongoDbTestRequestDto;
import com.qrmaster.api.model.BoardPostModel;
import com.qrmaster.api.service.BoardPostService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;


@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/board")
public class BoardController {

    private final Logger logger =  LoggerFactory.getLogger(BoardController.class);

    private final BoardPostService boardPostService;

    @PostMapping("/get-post")
    public ResponseEntity<?> getBoardPost(@Valid @RequestBody MongoDbTestRequestDto mongoDbTestRequestDto) throws Exception {

        logger.info("############# 게시글 조회 #############");

        BoardPostModel boardPostModel = boardPostService.getBoardPost(mongoDbTestRequestDto);

        logger.info("############# 게시글 조회 결과 #############");
        logger.info(boardPostModel.toString());

        return ResponseEntity.ok(boardPostModel);
    }

}
