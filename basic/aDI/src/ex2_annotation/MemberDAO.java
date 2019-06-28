package ex2_annotation;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class MemberDAO {

	@Autowired
	
	//@Resource(name="memberBean2") //두개이상일때
	@Qualifier("memberBean2")
		private MemberBean member;
//		public MemberDAO() {
//			
//		}
//		public MemberDAO(MemberBean member) {
//			this.member = member;
//		}
		
//		public void setMember(MemberBean member) {
//			this.member=member;
//		}
		public void insert() {
			System.out.println(member.getName()+"님 정보가 입력됩니다.");
		}
}
