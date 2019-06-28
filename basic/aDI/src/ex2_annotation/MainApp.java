package ex2_annotation;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex2_annotation/apConfig.xml");
		
		MemberBean mem = (MemberBean)context.getBean("memberBean");
		mem.output();
		
		MemberDAO dao = context.getBean("memberDAO",MemberDAO.class);
		dao.insert();

	}

}


