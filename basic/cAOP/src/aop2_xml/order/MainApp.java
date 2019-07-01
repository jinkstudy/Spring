package aop2_xml.order;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import aop1_xml.MessageBean;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("aop2_xml/order/applicationContext.xml");
		MemberBean bean = ctx.getBean("targetBean",MemberBean.class);
		bean.register();
		System.out.println("----------------------");
		bean.update("홍길동");

	}

}
