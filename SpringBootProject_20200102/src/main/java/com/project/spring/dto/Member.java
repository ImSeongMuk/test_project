package com.project.spring.dto;

import lombok.Getter;
import lombok.NonNull;
import lombok.Setter;
import lombok.ToString;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;

@Getter
@Setter
@ToString
@NonNull
public class Member {
	private String username;
    private String password;   
    private String name; 
    private boolean isAccountNonExpired;
    private boolean isAccountNonLocked;    
    private boolean isCredentialsNonExpired;    
    private boolean isEnabled;
    
    //아래는 시큐리티를 위한 추가
    private Collection<? extends GrantedAuthority> authorities;
   
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }
 
    public void setAuthorities(Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
    }
}
