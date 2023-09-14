package kr.ac.kopo.biz.news;


import java.net.URI;
import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;

import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import kr.ac.kopo.biz.secret.Secrets;


@Repository
public class NewsDAOImpl implements NewsDAO{

	@Override
	public ResponseEntity<String> searchNewsAPI() {
	
		String query = "경제 연준 금융";
		ByteBuffer buffer = StandardCharsets.UTF_8.encode(query);
		String enQuery = StandardCharsets.UTF_8.decode(buffer).toString();
		
		
		URI uri = UriComponentsBuilder.fromUriString("https://openapi.naver.com/")
				.path("v1/search/news.json")
				.queryParam("query", enQuery).queryParam("display", 10).queryParam("start", 1).queryParam("sort", "sim")
				.encode().build().toUri();
		
		RestTemplate restTem = new RestTemplate();
		Secrets secret = new Secrets();
		
		String clientId = secret.getClientId();
		String clientSecret = secret.getClientSecret();
		
		RequestEntity<Void> reqEntity = RequestEntity.get(uri).header("X-Naver-Client-Id", clientId)
									.header("X-Naver-Client-Secret", clientSecret).build();
		
		ResponseEntity<String> resEntity = restTem.exchange(reqEntity, String.class);
				
		return resEntity;
	}

	@Override
	public NewsVO getAllNewsList(ResponseEntity<String> entity) {
		
		String responseBody = null;
		
		if(entity.getStatusCode().is2xxSuccessful()) {
			responseBody = entity.getBody();
			System.out.println(responseBody);
		} else {
			System.out.println("fail : " + entity.getStatusCode());
		}
		
		NewsVO newsList = null;
		ObjectMapper map = new ObjectMapper();
		try {
			newsList = map.readValue(responseBody, NewsVO.class);
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (JsonProcessingException e) {
			e.printStackTrace();
		}
		return newsList;
	}
	
	

}
