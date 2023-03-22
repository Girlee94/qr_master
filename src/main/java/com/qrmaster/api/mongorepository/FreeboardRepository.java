package com.qrmaster.api.mongorepository;

import com.qrmaster.api.document.Freeboard;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreeboardRepository extends MongoRepository<Freeboard, String> {
	
	Optional<Freeboard>	findBy_idAndUsridx(String _id, long usrIdx);
}
