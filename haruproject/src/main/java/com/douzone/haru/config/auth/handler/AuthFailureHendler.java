package com.douzone.haru.config.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;

@Configuration
public class AuthFailureHendler implements AuthenticationFailureHandler {

	@Override
	public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
			AuthenticationException exception) throws IOException, ServletException {

		String userid = request.getParameter("userid");
		String userAuth = request.getParameter("auth");
		System.out.println("userid : " + userid + "userAuth" + userAuth);
		
		if(exception != null) {
			System.out.println(exception);
		}
		
		response.sendRedirect("/haru/faillogin");

	}

}
