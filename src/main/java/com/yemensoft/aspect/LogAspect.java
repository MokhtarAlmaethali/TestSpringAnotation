package com.yemensoft.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;
// to disable the functions to start the second class
//@Component
@Aspect

public class LogAspect {
	
	/*
	 * Advice:
	 * before
	 * after 
	 * afterThrowing
	 * afterReturning
	 * 
	 * by using around you can manage all the above
	 * around(powerful, can have before, after,afterThrowing, afterReturning together)
	 * 
	 * 
	 * 
	 */
	
	@Before("execution(* com.yemensoft.model.service.*.*(..))")

	public void before(){
		System.out.println("method starts");
	}
	

	@After("execution(* com.yemensoft.model.service.*.*(..))")
	public void after(){
		System.out.println("method ends");
	}
	
	@AfterThrowing("execution(* com.yemensoft.model.service.*.*(..))")
	public void afterthrowing(){
		System.out.println("exception happens");
	}
	@AfterReturning("execution(* com.yemensoft.model.service.*.*(..))")
	public void afterReturning(){
		System.out.println("after returning");
	}
	
	

}
