package com.bookmanager.app.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bookmanager.app.domain.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
}
