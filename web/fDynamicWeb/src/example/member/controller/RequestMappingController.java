package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import example.member.model.MemberVO;

@Controller
@RequestMapping("/re")
public class RequestMappingController {
	
	@RequestMapping(value="/request.do", method=RequestMethod.POST)
	public void request(MemberVO vo) {
		
		// 디비연결
		System.out.println("re/request.do 요청");
		System.out.println(vo.getName());
	}
	
	// ***********
	// 리턴형이 void이면 요청이름과 동일한 뷰 페이지 지정
	
}
