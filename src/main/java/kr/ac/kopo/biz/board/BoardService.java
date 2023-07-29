package kr.ac.kopo.biz.board;

import java.util.List;


public interface BoardService {
	
	List<BoardVO> getBoardList();
	
	BoardVO getBoardByNo(int postNo);
	
	void addBoard(BoardVO board);

}
