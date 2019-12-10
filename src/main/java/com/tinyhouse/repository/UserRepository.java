package com.tinyhouse.repository;

import org.springframework.data.repository.CrudRepository;

import com.tinyhouse.model.User;

public interface UserRepository extends CrudRepository<User, Long> {
	User findByUsername(String username);
}
