package com.qrmaster.api.board.dto.board;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.domain.Page;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardPageResponseDTO {

    private Page<GetBoardListDTO>   page;
}
