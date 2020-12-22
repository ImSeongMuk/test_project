package com.project.spring.DAO;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.project.spring.dto.Authority;
import com.project.spring.dto.Member;

@Repository
public class userDAOImpl implements userDAO{
	private static final String namespace="member";

	@Autowired//DB커넥션과 클로즈를 자동으로 해주는 SqlSession // 의존관계를 자동으로 연결(JAVA에서 제공) ==@autowired (Spring에서 제공)
	private SqlSessionTemplate sqlSession;
	
	public void setSqlSession(SqlSessionTemplate sqlSession) {
		this.sqlSession = sqlSession;
	}
	
	@Override
	public void insertUser(Member vo) throws Exception {
		System.out.println("테스트2"+vo.getUsername().toString());
        System.out.println("테스트2"+vo.getPassword().toString());
        System.out.println("테스트2"+vo.getName().toString());
        Member vo2 = new Member();
        vo2.setUsername("i,4700");
        vo2.setPassword("dsa");
        vo2.setName("sad");
		sqlSession.insert(namespace+".insertUser", vo2);
	}

	@Override
	public void insertAuthority(Authority vo) throws Exception {
		sqlSession.insert(namespace+".insertAuthority", vo);
	}
}
