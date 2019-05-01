package com.example.demo;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.example.demo.domain.User;
import com.example.demo.mappers.UserMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootMyBatisApplicationTests {

	@Autowired
	private UserMapper userMapper;
	
	 @Test    
	 public void findAllUsers()  {        
		 List<User> users = userMapper.findAllUsers();        
		 assertNotNull(users);        
		 assertTrue(!users.isEmpty());
	 }
	 
	 @Test    
	 public void findUserById()  {        
		 User user = userMapper.findUserById(1);        
		 assertNotNull(user);    
	 }
	    
	 @Test    
	 public void createUser() {        
		 User user = new User(0, "george", "george@gmail.com");        
		 userMapper.insertUser(user);        
		 User newUser = userMapper.findUserById(user.getUserId());        
		 assertEquals("george", newUser.getUserName());        
		 assertEquals("george@gmail.com", newUser.getUserEmail());    
	 }

}
