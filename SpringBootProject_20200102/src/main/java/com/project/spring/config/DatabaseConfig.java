package com.project.spring.config;

import javax.sql.DataSource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.transaction.annotation.EnableTransactionManagement;

// Database 에 대한 접속 정보를 나타낸다
@Configuration
@MapperScan(basePackages = "com.project.spring.mapper")
@EnableTransactionManagement
public class DatabaseConfig {
	
	@Bean
	public SqlSessionFactory sqlSessionFactory(DataSource dataSource) throws Exception{
		final SqlSessionFactoryBean sessionFactory = new SqlSessionFactoryBean();
		sessionFactory.setDataSource(dataSource);
		PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
		sessionFactory.setMapperLocations(resolver.getResources("classpath:mybatis/mapper/*.xml"));
		return sessionFactory.getObject();
	}
	
	@Bean
	public SqlSessionTemplate sqlSessionTemplate(SqlSessionFactory sqlSessionFactory) throws Exception {
	      final SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory);
	      return sqlSessionTemplate;
    }
	
}
