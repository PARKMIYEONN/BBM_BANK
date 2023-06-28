package kr.ac.kopo.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.ac.kopo.biz.board.BoardDAO;
import kr.ac.kopo.biz.board.BoardVO;
import kr.ac.kopo.biz.user.UserVO;
import kr.ac.kopo.controller.Controller;

public class PostingProcessController implements Controller{

	@Override
	public String handleRequest(HttpServletRequest request, HttpServletResponse response) {
		
		HttpSession session = request.getSession();
		UserVO uvo = (UserVO)session.getAttribute("loginUser");
		String title = request.getParameter("title");
		String writer = uvo.getUserId();
		String content = request.getParameter("content");

		BoardVO vo = new BoardVO();
		vo.setTitle(title);
		vo.setWriter(writer);
		vo.setContent(content);
		if(writer.equals("admin")) {
			vo.setPostPermission(0);
		}else {
			vo.setPostPermission(1);
		}
		
		BoardDAO dao = new BoardDAO();
		dao.posting(vo);
		
		
		
		
		return "redirect:/boardlist.do";
	}
	
	
	

}
