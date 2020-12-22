package com.project.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;
import com.project.spring.service.SpringBootService;


@Controller
public class MemberController {
	@Autowired
	SpringBootService springBootService;
	//@Autowired
	//private TestServiceImpl testService; 
	
	@GetMapping("/user/signup")
    public String dispSignup() {
        return "/signup";
    }
	
	@PostMapping("/user/signup")
    public String execSignup(Member member) throws Exception {
		try {
			//회원 데이터 저장
			springBootService.insertUser(member);
			
			//저장이 완료되면 권한 저장
			Authority authority = new Authority();
			authority.setUsername(member.getUsername());
			authority.setAuthority_name("USER");
			
			springBootService.insertAuthority(authority);
			System.out.println(member.getUsername() + "회원 가입 성공");
		} catch (Exception e) {
			System.out.println("error : "+e.toString());
		}
		
        return "redirect:/";
    }
}
