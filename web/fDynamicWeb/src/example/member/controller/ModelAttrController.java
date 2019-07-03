package example.member.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import example.member.model.MemberVO;

@Controller
public class ModelAttrController {
	
	// [2] modelattribute 설정하면 return하지 않아도 그 값이 view로 넘김.
	@ModelAttribute("message")
	public String attr1() {
		return "행복한 수요일";
	}
	@ModelAttribute("memberVO")
	public MemberVO attr2() {
		MemberVO vo = new MemberVO();
		vo.setId("003");
		vo.setName("홍길숙");
		vo.setAge(25);
		return vo;
	}
	
	@RequestMapping("/modelAttr.do")
	public void test() {
		//기본적인 방법뷰로 데이터를 전달하는 방법
		//1. Map
		//2. ModelAndView
		//3. Model
		
	}
}
