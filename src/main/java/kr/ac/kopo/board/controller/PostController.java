package kr.ac.kopo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.ac.kopo.biz.board.BoardDAO;
import kr.ac.kopo.biz.board.BoardVO;
import kr.ac.kopo.controller.Controller;

public class PostController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		String postNo = request.getParameter("postNo");
		
		BoardVO vo = new BoardVO();
		vo.setPostNo(Integer.parseInt(postNo));
		BoardDAO dao = new BoardDAO();
		BoardVO board = dao.getPost(vo);
		request.setAttribute("post", board);
		
		return "/jsp/board/post.jsp";
	}
	
	

}
