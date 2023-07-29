package kr.ac.kopo.biz.board;

import java.util.List;

public interface BoardDAO {
	
	List<BoardVO> selectAllBoard();
	
	BoardVO selectBoardByNo(int postNo);
	
	void insertBoard(BoardVO board);

}
