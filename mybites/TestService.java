package com.project.spring.service;

import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;

public interface TestService {
		//member insert
		public void insertUser(Member member) throws Exception;
		//member insert authority
		public void insertAuthority(Authority authority) throws Exception;
}
