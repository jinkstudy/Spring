package com.javassem.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.javassem.domain.BoardVO;
import com.javassem.service.BoardService;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService boardService;
	
//	@RequestMapping("/insertBoard.do")
//	public void insert() {
//		//DB연동 없이 화면만 변경하는 함수
//	}
			
		//원래는 기능없이 화면전환만 하는 경우에도, 위에 처럼 RequestMapping 해줘야 하지만
		//아래처럼 파일명을 {step}으로 변수로 받아서, 그것을 반환하도록 만들어놓으면,
		//화면전환만 하는 모든 경우를 아래 하나의 코드로 모두 해결 가능.
		@RequestMapping("/{step}.do")
		public String viewPage(@PathVariable String step) {
			return step;
		}
		

	
		// 글 목록 검색
		@RequestMapping("/getBoardList.do")
		public void getBoardList(BoardVO vo, Model model) {
			
			model.addAttribute("boardList", boardService.getBoardList(vo));
			// ViewResolver를 지정하지 않으면 아래처럼 페이지명 지정
			// return "views/getBoardList.jsp"; // View 이름 리턴
		}
	
		// 글 등록
		@RequestMapping(value = "/saveBoard.do")
		public String insertBoard(BoardVO vo) throws IOException {
			boardService.insertBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 수정
		@RequestMapping("/updateBoard.do")
		public String updateBoard(@ModelAttribute("board") BoardVO vo) {
			boardService.updateBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 삭제
		@RequestMapping("/deleteBoard.do")
		public String deleteBoard(BoardVO vo) {
			boardService.deleteBoard(vo);
			return "redirect:/getBoardList.do";
		}

		// 글 상세 조회
		@RequestMapping("/getBoard.do")
		public void getBoard(BoardVO vo, Model model) {
			model.addAttribute("board", boardService.getBoard(vo)); // Model 정보 저장			
		}

	}
