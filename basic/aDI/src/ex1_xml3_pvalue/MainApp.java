package ex1_xml3_pvalue;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainApp {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("ex1_xml3_pvalue/applicationContext.xml");
		
		//MemberBean mem = (MemberBean)context.getBean("mem");
		MemberBean mem = context.getBean("mem1",MemberBean.class);
		mem.output();
//		
		MemberBean mem2 = context.getBean("mem2",MemberBean.class);
		mem2.output();
		
		MemberDAO dao = context.getBean("dao1",MemberDAO.class);
		dao.insert();
		MemberDAO dao2 = context.getBean("dao2",MemberDAO.class);
		dao2.insert();
	}

}
