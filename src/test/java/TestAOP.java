import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yemensoft.model.service.UserService;
import com.yemensoft.model.service.UserService1;
import com.yemensoft.model.service.UserService2;

public class TestAOP {
	
	@Test
	public void testAOP(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		UserService2 userService= context.getBean(UserService2.class);
		userService.test();
		
		/*
		 * 
		 * design pattern: dynamic proxy
		 * AOP rely on IOC(the core of spring)
		 * 
		 * public class $proxy extends UserService2{
		 * 
		 * 		public void test()
		 * 		{
		 * 			try{
		 * 				try{
		 * 				//@Before
		 * 				//method.invoke()==>super.test();
		 * 				method.invoke(..);
		 * 				}finally{
		 * 						//@After
		 * 						}
		 * 						//@afterReturning
		 * 				}catch(){
		 * 						//@afterThrowing
		 * 						}
		 * 			}		
		 * 
		 * }
		 */
	}
	
}
