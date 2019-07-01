package board.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import board.BoardService;
import board.vo.BoardVO;

//Component 중에서 service 단 역할을 하는 객체생성
@Service("boardService") //boardService라는 이름으로 객체생성해주겠다.
public class BoardServiceImpl implements BoardService {
	
	@Autowired //setter와 생성자 없이 자동으로 생성.
	private BoardDAO boardDAO;

	public void insertBoard(BoardVO vo) {
		boardDAO.insertBoard(vo);
	}

	public void updateBoard(BoardVO vo) {
		boardDAO.updateBoard(vo);
	}

	public void deleteBoard(BoardVO vo) {
		boardDAO.deleteBoard(vo);
	}

	public BoardVO getBoard(BoardVO vo) {
		return boardDAO.getBoard(vo);
	}

	public List<BoardVO> getBoardList(BoardVO vo) {
		return boardDAO.getBoardList(vo);
	}
}
