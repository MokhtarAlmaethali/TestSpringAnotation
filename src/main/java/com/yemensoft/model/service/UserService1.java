package com.yemensoft.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemensoft.model.mapper.UserMapper;

@Service
public class UserService1 extends UserService{

	@Autowired
	private UserMapper userMapper;
	
	public void test(){
		System.out.println("userService1");
		System.out.println(userMapper);
	}

}
