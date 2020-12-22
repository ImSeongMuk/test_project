package com.project.spring.handlers;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import com.project.spring.dto.SecurityMember;

//로그인 성공 했을 경우 Handler
public class CustomLoginSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler{
	public CustomLoginSuccessHandler(String defaultTargetUrl) {
        setDefaultTargetUrl(defaultTargetUrl);
    }
	
    //로그인이 성공했을 경우 ip정보 가져오기
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, 
        Authentication authentication) throws ServletException, IOException {
        
        ((SecurityMember)authentication.getPrincipal()).setIp(getClientIp(request));
        //user ip를 확인하여 세션 유지?
        HttpSession session = request.getSession();
        if (session != null) {
            String redirectUrl = (String) session.getAttribute("prevPage");
            if (redirectUrl != null) {
                session.removeAttribute("prevPage");
                getRedirectStrategy().sendRedirect(request, response, redirectUrl);
            } else {
                super.onAuthenticationSuccess(request, response, authentication);
            }
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }
    }
    
    public static String getClientIp(HttpServletRequest request) {
        String ip = request.getHeader("X-Forwarded-For");
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("Proxy-Client-IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("WL-Proxy-Client-IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("HTTP_CLIENT_IP");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getHeader("HTTP_X_FORWARDED_FOR");
         }
         if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
             ip = request.getRemoteAddr();
         }
         System.out.println("user ip?"+ip);
         return ip;
    }
}
