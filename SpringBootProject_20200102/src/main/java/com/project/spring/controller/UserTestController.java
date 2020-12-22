package com.project.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.spring.dto.Member;
import com.project.spring.service.SpringBootService;

@Controller
public class UserTestController {
	
	@Autowired
	SpringBootService springBootService;
	
	@RequestMapping("/openapi/readUser/{username}")
    public @ResponseBody String  openApiReadUser(@PathVariable String username) throws Exception {
        Member member = springBootService.readUser(username);
        String userName= "사용자 이름" + member.getName();
        return userName;
    }
    
    @RequestMapping("/openapi/readAuthority/{username}")
    public @ResponseBody String  openApiReadAuthority(@PathVariable String username) throws Exception {
    	
        List<String> auths = springBootService.readAuthority(username);
        StringBuffer buf = new StringBuffer();
        for(String auth : auths) {
            buf.append(auth);
            buf.append(" ");
        }
        
        return buf.toString();
    }
    
}
