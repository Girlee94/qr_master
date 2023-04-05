package com.qrmaster.api.service;

import com.qrmaster.api.dto.board.BoardPageResponseDTO;
import com.qrmaster.api.dto.board.GetBoardListDTO;
import com.qrmaster.api.entity.mongo.Board;
import com.qrmaster.api.enums.DeleteFlag;
import com.qrmaster.api.repository.mongo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository   boardRep;

    public BoardPageResponseDTO getBoardList(int page) {

        BoardPageResponseDTO    response    =   new BoardPageResponseDTO();

        Page<Board> boardList   =   boardRep.getBoardList(DeleteFlag.VALID, PageRequest.of(page - 1, 10));
        Page<GetBoardListDTO>   boardListDTOS   =   new GetBoardListDTO().toDtoList(boardList);

        response.setPage(boardListDTOS);

        return response;
    }

    /*
    public List<Board> getBoardList(){
        return boardRep.findAll();
    }
     */

    public Board getBoard(String id){
        return boardRep.findById(id).orElseGet(Board::new);
    }

    public boolean isBoardExist(String id) throws Exception {
        Board board = boardRep.findById(id).orElseThrow(Exception::new);
        return board != null;
    }

    public void insertBoard(Board board){
        boardRep.save(board);
    }

    public void updateBoard(Board board){
        board.setUpdate_date(LocalDateTime.now());
        boardRep.save(board);
    }

    public void deleteBoard(String id) throws Exception {
        if (isBoardExist(id)) boardRep.deleteById(id);
    }

}
