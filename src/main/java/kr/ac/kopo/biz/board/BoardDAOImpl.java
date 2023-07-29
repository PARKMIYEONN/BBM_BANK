package kr.ac.kopo.biz.board;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


@Repository
public class BoardDAOImpl implements BoardDAO{
	
	@Autowired
	private SqlSessionTemplate sqlSession;

	@Override
	public List<BoardVO> selectAllBoard() {
		List<BoardVO> list = sqlSession.selectList("kr.ac.kopo.biz.baord.BoardDAO.selectAllBoard");
		return list;
	}

	@Override
	public BoardVO selectBoardByNo(int postNo) {
		BoardVO board = sqlSession.selectOne("kr.ac.kopo.biz.baord.BoardDAO.selectBoardByNo", postNo);
		return board;
	}

	@Override
	public void insertBoard(BoardVO board) {
		sqlSession.insert("kr.ac.kopo.biz.baord.BoardDAO.insertBoard", board);

	}

	
	
}
