package com.qrmaster.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "board")
public class BoardPostModel {

    @Id
    private String _id;

    private String title;

    private String content;

    private String author;

    private String createdAt;

    private String updatedAt;

}
