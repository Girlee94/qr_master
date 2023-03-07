package com.qrmaster.api.repository;

import com.qrmaster.api.MongoDbTestModel;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MongoDbTestRepository extends MongoRepository<MongoDbTestModel, String> {

    MongoDbTestModel findByUserid(String userid);

}
