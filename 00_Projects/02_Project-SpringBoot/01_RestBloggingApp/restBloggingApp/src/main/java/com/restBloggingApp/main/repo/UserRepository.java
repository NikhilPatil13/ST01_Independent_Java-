package com.restBloggingApp.main.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.restBloggingApp.main.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByEmailId(String emailId);

}
