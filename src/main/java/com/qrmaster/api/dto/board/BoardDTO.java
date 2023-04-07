package com.qrmaster.api.dto.board;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardDTO {

    private String id;
    private String title;
    private String contents;
    private String writer;
    private Date reg_date;
    private Date mod_date;

}
