package ex3_autowired;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		
		ApplicationContext ctx = 
				new ClassPathXmlApplicationContext("ex3_autowired/applicationContext.xml");
		MessageBean bean=ctx.getBean("message",MessageBean.class);
		bean.sayHello();
		
		

	}

}
