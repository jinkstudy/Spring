package aop3_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		// 스프링 설정파일 연동
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop3_annotation/applicationContext.xml");
		// targetBean 객체를 얻어와서 함수 호출
		MessageBean bean = ctx.getBean("targetBean",MessageBean.class);
	
		bean.sayHello();
		System.out.println("--------------------------------------");
		bean.engSayHello();
		System.out.println("**************************************");
	
	}
	
	//결과
	
//	[사전작업] : sayHello
//	[******사전작업******] : sayHello
//	sayHello() 호출
//	<사후작업> : sayHello
//	[******사후작업******] : sayHello
//	--------------------------------------
//	[사전작업] : engSayHello
//	[******사전작업******] : engSayHello
//	engSayHello() 호출
//	<사후작업> : engSayHello
//	[******사후작업******] : engSayHello
//	**************************************
//	test() 호출

}
