package com.example.demo.mappers;

import java.util.List;

import com.example.demo.domain.User;

public interface UserMapper {
	void insertUser(User user);
	List<User> findAllUsers();
	User findUserById(Integer id);
}
