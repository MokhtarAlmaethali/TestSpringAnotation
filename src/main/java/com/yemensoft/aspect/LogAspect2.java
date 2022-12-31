package com.yemensoft.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

//@Component
@Aspect
public class LogAspect2 {
//	com.yemensoft.model.service.AllClass.AllMethod and Param
	@Around("execution(* com.yemensoft.model.service.*.*(..))")
	
//	ProceedingJoinPoint reference to the target method
	public void around(ProceedingJoinPoint jp){
		String className=jp.getTarget().getClass().getName();
		String methodName=jp.getSignature().getName();
		long startTime=0;
		try{
			  try{
				//@Before
				  System.out.println(className+"-"+methodName+"- start to run");
				  startTime=System.currentTimeMillis();
			 	
				  jp.proceed(); //invoke target method
				  
			 	}finally{
			 	//@After
			 		long endtime=System.currentTimeMillis();
			 		System.out.println(className+"-"+methodName+"--ends."+"it takes"+(endtime-startTime)+"millis");
			 	}
			//@afterReturning
			  System.out.println(className+"-"+methodName+"--finish with no error");
			 	
			 	}catch(Throwable e){
				//@afterThrowing
			 		System.out.println(e.getMessage());
			 	}
			}		
		

}
