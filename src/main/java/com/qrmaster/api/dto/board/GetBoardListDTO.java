package com.qrmaster.api.dto.board;

import com.qrmaster.api.entity.mongo.Board;
import com.qrmaster.api.enums.DeleteFlag;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GetBoardListDTO {

    private String			_id;
    private long			user_idx;
    private String			title;
    private String			content;
    private DeleteFlag		delete_flag;
    private LocalDateTime	register_date;

    public Page<GetBoardListDTO> toDtoList(Page<Board> boardList) {

        Page<GetBoardListDTO>   boardListDTOS   =   boardList.map(board ->
                GetBoardListDTO.builder()
							._id(board.get_id())
							.user_idx(board.getUser_idx())
							.title(board.getTitle())
							.content(board.getContent())
							.delete_flag(board.getDelete_flag())
							.register_date(board.getRegister_date())
							.build());

        return boardListDTOS;
    }
}
