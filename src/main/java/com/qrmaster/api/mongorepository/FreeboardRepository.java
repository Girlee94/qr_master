package com.qrmaster.api.mongorepository;

import com.qrmaster.api.document.Freeboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FreeboardRepository extends MongoRepository<Freeboard, String> {


}
