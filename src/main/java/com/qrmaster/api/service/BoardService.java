package com.qrmaster.api.service;

import com.qrmaster.api.dto.PageDTO;
import com.qrmaster.api.dto.board.response.BoardPageResponseDTO;
import com.qrmaster.api.dto.board.response.GetBoardListDTO;
import com.qrmaster.api.dto.user.UserProfileDTO;
import com.qrmaster.api.entity.mongo.Board;
import com.qrmaster.api.enums.DeleteFlag;
import com.qrmaster.api.repository.mongo.BoardRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoardService {

    private final BoardRepository   boardRep;
    private final UserService       userService;

    public BoardPageResponseDTO getBoardList(int page) {

        BoardPageResponseDTO    response    =   new BoardPageResponseDTO();

        Page<Board> boardPage   =   boardRep.getBoardList(DeleteFlag.VALID, PageRequest.of(page - 1, 10));
        List<Long>  userIdxs    =   boardPage.getContent().stream()
                                                        .map(Board::getUser_idx)
                                                        .distinct()
                                                        .collect(Collectors.toList());

        List<UserProfileDTO>    userProfiles    =   userService.findUserProfiles(userIdxs);
        response.setPage(new PageDTO<>(boardPage, joinProfileOnBoard(boardPage.getContent(), userProfiles)));

        return response;
    }

    private List<GetBoardListDTO> joinProfileOnBoard(List<Board> boardList, List<UserProfileDTO> userProfiles) {

        return boardList.stream()
                .map(board -> {
                    UserProfileDTO  findProfileDTO  =   userProfiles.stream()
                            .filter(u -> u.getUsr_idx() == board.getUser_idx())
                            .findFirst()
                            .orElse(null);

                    return new GetBoardListDTO(board, findProfileDTO);
                })
                .collect(Collectors.toList());
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
