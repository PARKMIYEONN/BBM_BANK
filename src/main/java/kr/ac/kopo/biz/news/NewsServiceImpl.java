package kr.ac.kopo.biz.news;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class NewsServiceImpl implements NewsService{
	
	@Autowired
	private NewsDAO dao;

	@Override
	public NewsVO getAllNews() {
		ResponseEntity<String> entity = dao.searchNewsAPI();
		NewsVO newsList = dao.getAllNewsList(entity);
		return newsList;
	}
	
	

}
