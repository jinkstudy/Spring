package com.javassem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/getBoardList.do")
//	public void getBoardList(BoardVO vo,Model model) {
//		List<BoardVO> list= boardService.getBoardList(vo);
//		//(1) Model
//		//(2) ModelAndView
//		//(3) 함수위에 @ModelAttribute
//		model.addAttribute("boardList",list); //View단의 이름과 맞춰줘야함 
	//model은 리턴필요없음.
//	}
	
	public ModelAndView getBoardList(BoardVO vo) {
		ModelAndView mv = new ModelAndView();
		mv.addObject("boardList",boardService.getBoardList(vo));
		mv.setViewName("getBoardList");
		return mv;
		//modelandView는 꼭 리턴해야함
	
	}
	@RequestMapping("/insertBoard.do")
	public void insertBoard() {
		//리턴형이 void면 요청이름(insertBoard)와 동일한 뷰이름이 지정됨.
		// WEB-INF/views/+ insetBoard + .jsp 자동으로 지정됨.
		//db 연동 없이 페이지만 연결 
	}
	
	@RequestMapping("/saveBoard.do")
	
	public String saveBoard(BoardVO vo) {
		boardService.insertBoard(vo);
	
		return "redirect:getBoardList.do"; //완료 후 페이지 redirect 하겠다.
	}
	
	
	@RequestMapping("/getBoard.do")
	public ModelAndView getBoardDetail(BoardVO vo) {
		BoardVO result=boardService.getBoard(vo);
		
		updateCnt(result);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board",result);
		mv.setViewName("getBoard"); 
		
		
		return mv;
	}
	
	@RequestMapping("/deleteBoard.do")
	public String deleteBoard(BoardVO vo) {
		boardService.deleteBoard(vo);
		return "redirect:getBoardList.do";
	}
	
		
	@RequestMapping("/updateBoard.do")
	public String updateBoard(BoardVO vo) {
		boardService.updateBoard(vo);
	     System.out.println("실행");
		return "redirect:getBoardList.do";
	}
	
	public void updateCnt(BoardVO vo) {
		boardService.updateCnt(vo);
	}
	
	
	
	
	
	
	
	
	
	

}
