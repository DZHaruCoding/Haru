package com.douzone.haru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.haru.service.UserService;
import com.douzone.haru.vo.UserVo;

/*
 *  작성자 : 이승현
 *  회원가입 컨트롤러
 */
@Controller
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	UserService userService;
	
	// DB에 insert 하기전 비밀번호 암호화 해주는 인코더
	// 의존성 주입하고 사용
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@PostMapping("/join")
	public String join(UserVo vo) {
		
		System.out.println("[유저정보] : " +vo);
		// 비밀번호 암호화
//		vo.setUserPassword(bCryptPasswordEncoder.encode(vo.getUserPassword()));
//		
//		// 사용자 추가
//		userService.addUser(vo);
//		
//		System.out.println("[userVo]:"+vo);
		
		// 로그인 폼으로 리다이 렉트
		return "redirect:/loginForm";
	}
}
