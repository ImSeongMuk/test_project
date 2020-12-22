package com.project.spring.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.spring.dto.Member;
import com.project.spring.dto.SecurityMember;
import com.project.spring.mapper.SpringBootMapper;

@Service
public class CustomUserDetailsService implements UserDetailsService{

	private static final String ROLE_PREFIX = "ROLE_";
	
	@Autowired
    SpringBootMapper springBootMapper;
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Member member = new Member();
		try {
			member = springBootMapper.readUser(username);
			if(member != null) {
	            member.setAuthorities(makeGrantedAuthority(springBootMapper.readAuthority(username)));
	        }
		} catch (Exception e) {
			System.out.println(e.toString());
		}
		return new SecurityMember(member);
		
	}
	
	private static List<GrantedAuthority> makeGrantedAuthority(List<String> roles){
        List<GrantedAuthority> list = new ArrayList<>();
        roles.forEach(role -> list.add(new SimpleGrantedAuthority(ROLE_PREFIX + role)));
        return list;
    }
}
