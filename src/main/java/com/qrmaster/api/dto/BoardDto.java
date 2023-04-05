package com.qrmaster.api.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class BoardDto {

    private String id;
    private String title;
    private String contents;
    private String writer;
    private Date reg_date;
    private Date mod_date;

}
