package com.yassine.gamess.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.yassine.gamess.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {
	User findByUsername(String username);
}