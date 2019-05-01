package com.example.demo.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.SelectKey;

import com.example.demo.domain.User;

public interface UserMapper {
	
	@Insert("insert into users(name,email) values (#{userName}, #{userEmail})")
	@SelectKey(statement = "call identity()", keyProperty = "userId", 
				before = false, resultType = Integer.class)
	void insertUser(User user);
	
	@Select("select id, name, email from users")
	List<User> findAllUsers();
	
	@Select("select id, name, email from users WHERE id=#{id}")
	User findUserById(Integer userId);
}
