package example.member.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import example.member.model.MemberVO;

@Controller
public class ParameterController {

	@RequestMapping("/param.do")
	// param.do 요청을 받아서 뷰 param.jsp에서 파라메터 값 출력
	public void test(String id, int age) {
		System.out.println("param.do 요청 -> "+id+"/"+age);
		
	}
	@RequestMapping("/paramForm.do")
	public void test2(MemberVO vo, HttpSession session) {
		//System.out.println(vo.getName());
		System.out.println("paramForm.do 요청 ->");
		String dbId="001";
		String dbName="홍길동";
		
		// 입력값과 DB값이 모두 동일하다면 세션에 저장
		if(vo.getId().equals(dbId) && vo.getName().equals(dbName)) {
			session.setAttribute("login", vo );
			
		}
		
		
		
	
		
	}
}
