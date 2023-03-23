package com.qrmaster.api.mongorepository;

import com.qrmaster.api.document.FreeBoard;
import com.qrmaster.api.enums.DeleteFlag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FreeBoardRepository extends MongoRepository<FreeBoard, String> {
	
	Optional<FreeBoard>	findBy_idAndUsridx(String _id, long usrIdx);
	
	Page<FreeBoard> findAllByDeleteFlag(DeleteFlag deleteFlag, Pageable pageable);
	
	Optional<FreeBoard>	findBy_idAndDeleteFlag(String _id, DeleteFlag deleteFlag);
}
