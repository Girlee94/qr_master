package com.qrmaster.api.dto.board.response;

import com.qrmaster.api.dto.PageDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class BoardPageResponseDTO {

    private PageDTO<GetBoardListDTO>    page;
}
