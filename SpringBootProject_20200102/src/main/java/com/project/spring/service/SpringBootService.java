package com.project.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;
import com.project.spring.dto.SpringBoot;
import com.project.spring.mapper.SpringBootMapper;

@Service
public class SpringBootService{

	@Autowired
	SpringBootMapper springBootMapper;
	
	public List<SpringBoot> getAll() throws Exception{
		return springBootMapper.getAll();
	}
	//spring db 안에 있는 user 테이블
	public Member readUser(String username) throws Exception{
		return springBootMapper.readUser(username);
	}
	//spring db 안에 있는 user 테이블
	public List<String> readAuthority(String username)throws Exception{
		return springBootMapper.readAuthority(username);
	}
	
	//회원가입
	public void insertUser(Member member) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        System.out.println("테스트"+member.getUsername().toString());
        System.out.println("테스트"+member.getPassword().toString());
        System.out.println("테스트"+member.getName().toString());
        
        springBootMapper.insertUser(member);
	}
	public void insertAuthority(Authority authority) throws Exception {
		springBootMapper.insertAuthority(authority);
	}
	
	
}
