package com.yemensoft.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemensoft.model.mapper.UserMapper;

@Service
public class UserService2 extends UserService{

	@Autowired
	private UserMapper userMapper;
	
	public void test(){
		System.out.println("userService2");
//		to made error to know if it goes throw the excepion
		Integer.parseInt("s");
		System.out.println(userMapper);
	}

}
