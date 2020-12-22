package com.project.spring.DAO;

import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;

public interface userDAO {
	
	public void insertUser(Member vo) throws Exception;
	public void insertAuthority(Authority vo) throws Exception;
}
