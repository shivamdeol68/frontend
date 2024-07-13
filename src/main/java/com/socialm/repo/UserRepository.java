package com.socialm.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.socialm.entity.User;

public interface UserRepository extends JpaRepository<User, Long>{

	User findByUsername(String username);
}
