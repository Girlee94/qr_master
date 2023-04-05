package com.qrmaster.api.repository.maria;

import com.qrmaster.api.entity.maria.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

}
