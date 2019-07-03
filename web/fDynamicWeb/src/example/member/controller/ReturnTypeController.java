package example.member.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ReturnTypeController {
	@RequestMapping("/map.do")
	public Map test() {
		Map<String,String> m = new HashMap<String,String>();
		m.put("age","22");
		m.put("hobby","음주가무");
		return m;
		//리턴형이 Map인 경우 - 뷰페이지 자동 지정
	}
	@RequestMapping("/model.do")
	public void abc(Model m) {
		//Model 인자에 지정- 값을 넘겨받는것이 아니고!
		//뷰쪽으로 전달하는 객체 입니다.
		m.addAttribute("message","오늘은 뭐 드실거");
		m.addAttribute("addr","이동네");
	}
}
