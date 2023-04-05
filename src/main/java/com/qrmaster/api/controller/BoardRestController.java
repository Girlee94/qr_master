package com.qrmaster.api.controller;

import com.qrmaster.api.common.ErrorCode;
import com.qrmaster.api.common.JsonResult;
import com.qrmaster.api.dto.BoardDto;
import com.qrmaster.api.dto.board.BoardPageResponseDTO;
import com.qrmaster.api.entity.mongo.Board;
import com.qrmaster.api.service.BoardService;
import com.qrmaster.api.validation.BoardValidation;
import lombok.RequiredArgsConstructor;
import net.minidev.json.JSONObject;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardRestController {

    private final BoardService		boardService;
    private final BoardValidation	boardValidation;
    private final JsonResult		result;

    @GetMapping
    public ResponseEntity<BoardPageResponseDTO> getBoardList(@RequestParam(required = true) int page) {

        BoardPageResponseDTO	response	=	boardService.getBoardList(page);

        return ResponseEntity.ok()
                .body(response);
    }

    /*
    @GetMapping("/list")
    public List<Board> getBoardList(){
        return boardService.getBoardList();
    }
     */

    @GetMapping("/data")
    public Board getBoard(String id){
        return boardService.getBoard(id);
    }

    @PostMapping("/write")
    public JSONObject insertBoard(
              @RequestBody BoardDto boardDto
            , BindingResult bindingResult
    ){
        try {
            boardValidation.validate(boardDto, bindingResult);
            if(bindingResult.hasErrors()) throw new Exception();

            Board board = makeBoardEntity(boardDto);
            board.setRegister_date(LocalDateTime.now());
            boardService.insertBoard(board);
            
            return result.getData(ErrorCode.SUCCESS_CODE, "게시글이 등록되었습니다.");

        } catch (Exception e){
            // 로그
            return result.getData(ErrorCode.INVALID_PARAMETER);
        }

    }

    @PutMapping("/update")
    public JSONObject updateBoard(
              @RequestBody BoardDto boardDto
            , BindingResult bindingResult
    ){

        try {
            boardValidation.validate(boardDto, bindingResult);
            if(bindingResult.hasErrors()) throw new Exception();

            Board board = makeBoardEntity(boardDto);
            board.set_id(boardDto.getId());
            boardService.updateBoard(board);

            return result.getData(ErrorCode.SUCCESS_CODE, "업데이트가 완료되었습니다.");

        } catch (Exception e){
            // 로그
            return result.getData(ErrorCode.INVALID_PARAMETER);
        }
    }

    @DeleteMapping("/delete")
    public JSONObject deleteBoard(@RequestBody BoardDto boardDto){
        try {
            boardService.deleteBoard(boardDto.getId());
            return result.getData(ErrorCode.SUCCESS_CODE, "게시글이 삭제되었습니다.");

        } catch (Exception e){
            // 로그
            return result.getData(ErrorCode.INVALID_PARAMETER);
        }
    }

    private Board makeBoardEntity(BoardDto boardDto){
        Board board = new Board();
        board.setTitle(boardDto.getTitle());
        board.setContent(boardDto.getContents());
        return board;
    }
}
