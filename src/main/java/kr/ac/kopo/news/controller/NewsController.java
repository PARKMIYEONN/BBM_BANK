package kr.ac.kopo.news.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import kr.ac.kopo.biz.news.NewsItem;
import kr.ac.kopo.biz.news.NewsService;
import kr.ac.kopo.biz.news.NewsVO;

@Controller
public class NewsController {
	
	@Autowired
	NewsService service;
	
	@GetMapping("/news")
	public String newsList(HttpServletRequest request){
		
		NewsVO vo = service.getAllNews();
		List<NewsItem> items = vo.getItems();
		
		request.setAttribute("newsList", items);
		
		return "news/news";
		
	}

}
