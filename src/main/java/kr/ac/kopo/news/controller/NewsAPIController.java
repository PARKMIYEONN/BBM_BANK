package kr.ac.kopo.news.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import kr.ac.kopo.biz.news.NewsDAO;

@RestController
public class NewsAPIController {
	
	@Autowired
	NewsDAO dao; 
	
	@GetMapping("/newsjson")
	public ResponseEntity<String> naverAPITest() {
		
		return dao.searchNewsAPI();
	}

}
