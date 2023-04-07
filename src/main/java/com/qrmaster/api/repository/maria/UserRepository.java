package com.qrmaster.api.repository.maria;

import com.qrmaster.api.entity.maria.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

//	List<User>  findByUsridxIn(List<Long> userIdxs);

	@Query(value = "select * from user where usr_idx in :usrIdxs", nativeQuery = true)
	List<User>  findByUsrIdxs(@RequestParam("usrIdxs") List<Long> usrIdxs);
}
