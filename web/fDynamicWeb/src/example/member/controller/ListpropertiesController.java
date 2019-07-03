package example.member.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import example.member.model.MemberVO;
import example.member.model.MemberVOList;

@Controller //controller 역할임을 알려줘야함
public class ListpropertiesController {
	@RequestMapping("/multiInsert.do")
	//넘어오는 값을 test(a) a로 받겟다.
	public void test(MemberVOList memberList) {
		System.out.println("multiInsert.do 요청");
		for(MemberVO vo:memberList.getList())
			System.out.printf("state=%s, id=%s ,name=%10s,age=%d \n",vo.isState(),vo.getId(),vo.getName(),vo.getAge());
		
	}
}
