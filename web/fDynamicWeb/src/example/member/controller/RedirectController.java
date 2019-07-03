package example.member.controller;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class RedirectController {
	
	@RequestMapping("/select.do")
	public ModelAndView select() {
		System.out.println("select.do 요청");
		ModelAndView mv = new ModelAndView();
		mv.addObject("info","목록보는 페이지입니다.");
		mv.setViewName("redirectResult");
		return mv;
	}
	@RequestMapping("/insert.do")
	public String insert() {
		System.out.println("insert.do 요청");
		return "redirect:select.do";
	}
}
