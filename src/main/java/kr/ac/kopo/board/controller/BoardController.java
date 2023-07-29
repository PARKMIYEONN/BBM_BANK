package kr.ac.kopo.board.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import kr.ac.kopo.biz.board.BoardService;
import kr.ac.kopo.biz.board.BoardVO;

@Controller
public class BoardController {
	
	@Autowired
	private BoardService service;
	
	@GetMapping("/board")
	public String list(HttpServletRequest request) {
		List<BoardVO> boardList = service.getBoardList();
		request.setAttribute("boardList", boardList);
		
		return "board/boardlist";
	}
	
	
	
	@GetMapping("/board/{postNo}")
	public ModelAndView detail(HttpServletRequest request, @PathVariable("postNo") int postNo) {
		
		BoardVO vo = service.getBoardByNo(postNo);
		
		ModelAndView mav = new ModelAndView();
		
		mav.setViewName("board/post");
		
		mav.addObject("post", vo);
		
		return mav;
	}
	
	
	

}
