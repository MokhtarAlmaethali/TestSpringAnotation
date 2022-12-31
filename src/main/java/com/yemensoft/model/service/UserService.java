package com.yemensoft.model.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yemensoft.model.mapper.UserMapper;
/*
@Service
// if the class is abstract it can't be bean 
public class UserService {
*/	

public abstract class UserService{
	@Autowired
	private UserMapper userMapper;
	public void test(){
		System.out.println(userMapper);
	}

}
