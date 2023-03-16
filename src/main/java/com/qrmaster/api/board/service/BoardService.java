package com.qrmaster.api.board.service;

import com.qrmaster.api.board.repository.Board;
import com.qrmaster.api.board.repository.BoardRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@AllArgsConstructor
public class BoardService {

    private final BoardRepository boardRepository;

    public List<Board> getBoardList(){
        return boardRepository.findAll();
    }

    public Board getBoard(String id){
        return boardRepository.findById(id).orElseGet(Board::new);
    }

    public boolean isBoardExist(String id) throws Exception {
        Board board = boardRepository.findById(id).orElseThrow(Exception::new);
        return board != null;
    }

    public void insertBoard(Board board){
        boardRepository.save(board);
    }

    public void updateBoard(Board board){
        board.setMod_date(new Date());
        boardRepository.save(board);
    }

    public void deleteBoard(String id) throws Exception {
        if (isBoardExist(id)) boardRepository.deleteById(id);
    }
}
