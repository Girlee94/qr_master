package com.qrmaster.api.dto.board.response;

import com.qrmaster.api.dto.user.UserProfileDTO;
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
    private long            usr_idx;
	private String          usr_nick;
    private String			title;
    private String			content;
    private DeleteFlag		delete_flag;
    private LocalDateTime	register_date;

	public GetBoardListDTO(Board board, UserProfileDTO userProfileDTO) {
		setBoard(board);
		setUserProfile(userProfileDTO);
	}

	public void setBoard(Board board) {
		this._id            =   board.get_id();
		this.usr_idx        =   board.getUser_idx();
		this.title          =   board.getTitle();
		this.content        =   board.getContent();
		this.delete_flag    =   board.getDelete_flag();
		this.register_date  =   board.getRegister_date();
	}

	public void setUserProfile(UserProfileDTO userProfileDTO) {
		this.usr_nick   =   userProfileDTO.getUsr_nick();
	}

    public Page<GetBoardListDTO> toDtoList(Page<Board> boardList) {

        Page<GetBoardListDTO>   boardListDTOS   =   boardList.map(board -> GetBoardListDTO.builder()
																						._id(board.get_id())
																						.usr_idx(board.getUser_idx())
																						.title(board.getTitle())
																						.content(board.getContent())
																						.delete_flag(board.getDelete_flag())
																						.register_date(board.getRegister_date())
																						.build());

        return boardListDTOS;
    }
}
