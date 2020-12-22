package com.project.spring.service;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.spring.DAO.userDAO;
import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;
import com.project.spring.mapper.SpringBootMapper;

@Service
public class TestServiceImpl implements TestService{
	
	@Resource
	userDAO userDao; 
	
	@Transactional
	public void insertUser(Member member) throws Exception{
		// 비밀번호 암호화 후 db 저장
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        member.setPassword(passwordEncoder.encode(member.getPassword()));
        System.out.println("테스트"+member.getUsername().toString());
        System.out.println("테스트"+member.getPassword().toString());
        System.out.println("테스트"+member.getName().toString());
        
		userDao.insertUser(member);
	}
	
	@Transactional
	public void insertAuthority(Authority authority) throws Exception{
		userDao.insertAuthority(authority);
	}
}
