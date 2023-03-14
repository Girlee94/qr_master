package com.qrmaster.api.service;

import com.qrmaster.api.dto.MongoDbTestRequestDto;
import com.qrmaster.api.model.BoardPostModel;
import com.qrmaster.api.repository.MongoDbBoardRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class BoardPostService {

    private final Logger logger = LoggerFactory.getLogger(BoardPostService.class);

    private final MongoDbBoardRepository mongoDbBoardRepository;

    public BoardPostModel getBoardPost(MongoDbTestRequestDto mongoDbTestRequestDto) throws Exception {

        BoardPostModel boardPostModel = mongoDbBoardRepository.findByAuthor(mongoDbTestRequestDto.getAuthor());

        return boardPostModel;
    }

}
