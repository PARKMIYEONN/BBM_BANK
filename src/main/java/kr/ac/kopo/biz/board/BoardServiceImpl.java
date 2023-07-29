package kr.ac.kopo.biz.board;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BoardServiceImpl implements BoardService{
	
	@Autowired
	private BoardDAO dao;

	@Override
	public List<BoardVO> getBoardList() {
		List<BoardVO> list = dao.selectAllBoard();
		return list;
	}

	@Override
	public BoardVO getBoardByNo(int postNo) {
		BoardVO vo = dao.selectBoardByNo(postNo);
		return vo;
	}

	@Override
	public void addBoard(BoardVO board) {
		dao.insertBoard(board);
	}
	
	

}
