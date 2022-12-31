package com.yemensoft.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;

import com.yemensoft.model.service.UserService;
// This annotation to tell the spring this is the controller
@Controller
public class UserController {
//	when we use the annotation we dont need to generate the setter method

//	let spring to auto inject the dependency 
	@Autowired
	
//	the only way to set value to private instance without using set method is to use
//	java reflection
	
//	to determine which service are qualified to inject 
//	it user when we have more than one qualified component
	@Qualifier("userService2")
	private UserService userService ;

	public void test(){
		userService.test();
	}
}
