package com.douzone.haru.config.auth.handler;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;

import com.douzone.haru.config.auth.PrincipalDetails;
import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.vo.UserVo;

@Configuration
public class AuthSuccessHandler implements AuthenticationSuccessHandler {

	private RequestCache requestCache = new HttpSessionRequestCache();

	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {

		// 인증처리중 발생하는 예외처리
		SavedRequest savedRequest = requestCache.getRequest(request, response);
		
		System.out.println(" savedRequest : " + savedRequest);
		
		if (savedRequest != null) {
			requestCache.removeRequest(request, response);
			clearAuthenticationAttributes(request);
		}
		
		// 응답 해더 타입
		String accept = request.getHeader("accept");
		System.out.println("accept : " +accept);
		
		
		UserDetails userDetails = new PrincipalDetails(null);
		
		if (SecurityContextHolder.getContext().getAuthentication() != null) {
			Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
			if (principal != null && principal instanceof UserDetails) {
				userDetails = (UserDetails) principal;
				System.out.println("userDetails : " + userDetails);
			}
		}

//		if (accept == null || accept.matches(".*application/json.*") == false) {
//
//            request.getSession(true).setAttribute("loginNow", true);
//            getRedirectStrategy().sendRedirect(request, response, "/guestbook");  
//            // 메인으로 돌아가! 
//            // 이전페이지로 돌아가기 위해서는 인증페이지로 가기 전 URL을 기억해 놓았다가  
//            return;
//        }

		MappingJackson2HttpMessageConverter jsonConverter = new MappingJackson2HttpMessageConverter();
		MediaType jsonMimeType = MediaType.APPLICATION_JSON;
		
		System.out.println("jsonMineType : " + jsonMimeType);
		
		UserVo vo = new UserVo();
		vo.setUserEmail(userDetails.getUsername());
		vo.setUserName(((PrincipalDetails) userDetails).getUserName());
		
		System.out.println(vo);
		
		JsonResult jsonResult = JsonResult.success(vo);
		System.out.println("jsonResult : " + jsonResult);
		
		if (jsonConverter.canWrite(jsonResult.getClass(), jsonMimeType)) {
			jsonConverter.write(jsonResult, jsonMimeType, new ServletServerHttpResponse(response));
		}
	}

	//////////////////////////////////////////////////////////////////////
//	UserDetails userDetails = (UserDetails) authentication.getPrincipal();
//	String username = userDetails.getUsername();
//	String userAuth = request.getParameter("auth");System.out.println("userid : "+username+"userAuth"+userAuth);
//
//	response.sendRedirect("/");
//	}


	// 스프링 시큐리티가 로그인 관련 로그인 실페후 세션에 남긴 에러를 지워주는 메소드
	private void clearAuthenticationAttributes(HttpServletRequest request) {
		HttpSession session = request.getSession(false);
		
		System.out.println("session : " + session);
		
		if (session == null) {
			return;
		}

		//
		session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);
	}

	public void setRequestCache(RequestCache requestCache) {
		this.requestCache = requestCache;
	}

}
