package com.user_service.userservice.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user_service.userservice.model.User;

public interface UserRepository extends JpaRepository<User,Long>{
	Optional<User> findByEmail(String email);

}
