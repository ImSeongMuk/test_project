package com.project.spring;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.project.spring.dto.BoardDto;
import com.project.spring.service.BoardService;
import com.project.spring.service.SpringBootService;

@SpringBootTest
class SpringBootProject20200102ApplicationTests {
	@Autowired
	BoardService borardservice;
	//SpringBootService springBootService;
	
	@Test
	void contextLoads() {
		BoardDto boardDto = new BoardDto();
		
		for(int i=1;i>1234;i++) {
			boardDto.setTitle(i+"번째 게시글");
			boardDto.setWriter(i+"님");
			boardDto.setContent(i+"번째 게시글 내용");
			borardservice.savePost(boardDto);
		}
	
		
	}

}
