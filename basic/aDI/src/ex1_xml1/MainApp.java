package ex1_xml1;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		//객체생성을 스프링컨테이너가 해주는것.
		// 이단계에서 객체생성됨
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml1/applicationContext.xml");
		
		//MessageBean bean = context.getBean("bean",MessageBean.class);
		//MessageBean bean = context.getBean("bean1",MessageBean.class);
		MessageBean bean = (MessageBean)context.getBean("ko");
		bean.sayHello("홍길자");
		
		MessageBean bean2 = (MessageBean)context.getBean("en");
		bean2.sayHello("hong");
		
		//위에서 생성해서 메모리에 올려놓은 후에 불러서 쓰는 개념 --> 실행할때 생성하는 것이 아님
		MessageBean bean3 = (MessageBean)context.getBean("en");
		bean3.sayHello("hong");
		
	}

}
