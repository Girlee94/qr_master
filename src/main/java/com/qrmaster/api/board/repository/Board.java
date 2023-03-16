package com.qrmaster.api.board.repository;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "board")
@Data
public class Board {

    @Id
    private String id;

    private String title;
    private String contents;
    private String writer;
    private Date reg_date;
    private Date mod_date;

}
