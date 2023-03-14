package com.qrmaster.api.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Document(collection = "test")
public class MongoDbTestModel {

    @Id
    private String _id;
    private String userid;
    private String username;

}
