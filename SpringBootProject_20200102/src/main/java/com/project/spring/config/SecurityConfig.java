package com.project.spring.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.project.spring.handlers.CustomLoginSuccessHandler;
import com.project.spring.service.CustomUserDetailsService;

//WebSecurityConfigurerAdapter를 상속받아 Security 설정
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
    CustomUserDetailsService customUserDetailsService;
 
    
    //로그인이 성공했을경우 ip정보 가져오기
    @Bean
    public AuthenticationSuccessHandler successHandler() {
      return new CustomLoginSuccessHandler("/");
    }
    
    @Override
    public void configure(WebSecurity web) throws Exception {
    	// static 디렉터리의 하위 파일 목록은 인증 무시 ( = 항상통과 )
        web.ignoring()
        	.antMatchers("/openapi/**","/css/**", "/js/**", "/img/**", "/lib/**");
    }
    
    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	//.authorizeRequests() 로그인 페이지 
    	//.antMatchers("/", "/login").permitAll() 로그인이 안된경우에 접속할 수 있는 경로 권한 설정 현재 "/", "/login"경로 만 해제
    	//.anyRequest().authenticated() 그외의 모든 요청은  인증된 사용자만 접근할 수 있다.
    	//.formLogin() .successHandler(successHandler())은 로그인 성공후 실행하는 핸들러를 나타낸다.
        http
        	.csrf()
        	.disable()
        	.authorizeRequests()
        		.antMatchers("/", "/login","/user/**","/board/search").permitAll()
        		.antMatchers("/admin").hasRole("ADMIN")
        		.anyRequest().authenticated()
        		.and()
        	.formLogin()
        		.loginPage("/login")
        		.successHandler(successHandler())
        		.and()
        	.logout()
        		.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
        		.logoutSuccessUrl("/")
        		.invalidateHttpSession(true)
        		.and()
            .exceptionHandling().accessDeniedPage("/user/denied");// 403 예외처리 핸들링
    }
    //Spring Security에서 제공하는 비밀번호 암호화 객체
    @Bean
    public PasswordEncoder passwordEncoder() {
      return new BCryptPasswordEncoder();
    }
    
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserDetailsService).passwordEncoder(passwordEncoder());
    }
}
