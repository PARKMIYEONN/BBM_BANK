package kr.ac.kopo.biz.news;

import org.springframework.http.ResponseEntity;

public interface NewsDAO {
	
	ResponseEntity<String> searchNewsAPI();
	
	NewsVO getAllNewsList(ResponseEntity<String> entity);
	

}
