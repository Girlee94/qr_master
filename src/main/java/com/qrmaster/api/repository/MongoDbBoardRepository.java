package com.qrmaster.api.repository;

import com.qrmaster.api.model.BoardPostModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDbBoardRepository extends MongoRepository<BoardPostModel, String> {

    BoardPostModel findByAuthor(String author);

}
