package com.qrmaster.api.repository.mongo;

import com.qrmaster.api.entity.mongo.Board;
import com.qrmaster.api.enums.DeleteFlag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends MongoRepository<Board, String> {

    @Query(value = "{'delete_flag': ?0}", sort = "{'register_date':  -1}")
    Page<Board> getBoardList(DeleteFlag deleteFlag, Pageable pageable);
}
