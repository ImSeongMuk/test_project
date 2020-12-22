package com.project.spring.mapper;


import java.util.List;

import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;
import com.project.spring.dto.SpringBoot;

public interface SpringBootMapper {
	
	//SpringBoot 형식의 클래스를 list값으로 받아오기
	public List<SpringBoot> getAll() throws Exception;
	
	//spring db 안에 있는 user 테이블
	public Member readUser(String username) throws Exception;
	
	//spring db 안에 있는 user 테이블
	public List<String> readAuthority(String username) throws Exception;
	
	//회원 가입
	public void insertUser(Member member);
	public void insertAuthority(Authority vo) throws Exception;
	
	
	
}
