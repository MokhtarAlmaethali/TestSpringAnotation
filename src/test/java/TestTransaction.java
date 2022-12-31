import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yemensoft.model.service.AccountService;

public class TestTransaction {

	@Test
	public void test(){
		ApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		AccountService accountService= context.getBean(AccountService.class);
		accountService.transferMoney();
	}
}
