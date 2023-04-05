package com.qrmaster.api.dto.board.response;

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
