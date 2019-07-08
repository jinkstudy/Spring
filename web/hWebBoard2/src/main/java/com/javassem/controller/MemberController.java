package com.javassem.controller;

import java.util.Date;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.dao.MemberDAO;
import com.javassem.domain.MemberVO;
import com.javassem.service.MemberService;

@Controller
@RequestMapping("/user")
public class MemberController {

//	@RequestMapping("user/userJoin.do")
//	@RequestMapping("/userJoin.do")
//	public void common() {
//		
//	}
	
	// 기능 없이 화면전환만 하는 경우. 아래와 같이 하나의 코딩으로 통합할 수 있다.
	@RequestMapping(value="{url}.do")
	public String common(@PathVariable String url) {
		System.out.println(url);
		if(url.equals("index")) {
			return "../index";
		}
		return "/user/"+url;
	}
	
	//===================================
	@Autowired
	MemberService memberService;
	
	
	//회원가입
	@RequestMapping("/userInsert.do")
	public ModelAndView insert(MemberVO vo) {
		int result = memberService.userInsert(vo);
		String message = "가입되지 않았습니다.";
		if(result>0) message = vo.getUserName()+"님 가입을 축하합니다.";
		
		ModelAndView mv = new ModelAndView();
		mv.addObject("result",result);
		mv.addObject("message",message);
		mv.setViewName("user/userJoin_ok");
		return mv;
	}
	
	//ajax로 불려짐.
	@RequestMapping(value="/idCheck.do",produces="application/text;charset=utf8")
	@ResponseBody //ajax로 불려진 경우 반드시 기술해줘야 결과 return 가능
					//해당 코드가 없으면 비동기 통신이 안이뤄짐. 
					//원래Spring은  return값에 해당하는 view페이지 지정이지만, RESponseBody를 하면 값반환가능
	public String idcheck(MemberVO vo) {
		// 인자로 String userId로 받아도 됨
		MemberVO memberVO = memberService.idCheck_Login(vo);
		String result = "ID 사용 가능합니다.";
		if(memberVO != null) result = "중복된 ID 입니다.";
		return result; 
		
	}
	
	@RequestMapping("/login.do")
	public String login(MemberVO vo, HttpSession session) {
		MemberVO result= memberService.idCheck_Login(vo);
		if(result == null || result.getUserId()==null) {
			return "/user/userLogin";
		}else {
			//***로그인 ㅅ어공
			session.setAttribute("sessionTime", new Date().toLocaleString());
			session.setAttribute("userName", result.getUserName());
		}
		
		return "/user/Main";
	}
	
	
	
}
