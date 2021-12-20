package com.douzone.haru.config.auth.handler;

import java.io.IOException;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

// 스프링 시큐리티 컨텍스트 내에서 관리하기 위한 컨포넌트 빈등록
@Component
public class AuthenticationEntryPointHandler implements AuthenticationEntryPoint {
	
	@Override
	public void commence(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			AuthenticationException authException) throws IOException, ServletException {
		
		// 쿼리를 제외한 프로토콜+도메인+포트번호+컨텍스트 경로+서블릿 경로를 구하고
		String request = httpServletRequest.getRequestURI();
		
		System.out.println("여기로 왔나~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
		
		if(request.contains("http://localhost:3000/")) {
			httpServletResponse.sendError(HttpServletResponse.SC_FORBIDDEN);
			System.err.println("여기로 왔니!!!!!!!!!!!!!1");
		} else {
			httpServletResponse.sendRedirect("http://localhost:3000/authentication/basic/login");
			System.out.println("아니면 여기니!!");
		}
		
	
	
	}

}
