import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yemensoft.controller.UserController;

public class TestIOCAnotation {


	@Test
	public void test1(){
//		1. init IOC container
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
//		2. get bean from IOC container
		UserController userController=context.getBean(UserController.class);
		
		userController.test();
		
		
	}
}
