package com.douzone.haru.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.douzone.haru.config.auth.PrincipalDetails;
import com.douzone.haru.service.UserService;
import com.douzone.haru.service.email.MailService;
import com.douzone.haru.vo.UserVo;

/*
 *  작성자 : 이승현
 *  - user Controller
 *  - 회원가입, 비밀번호 변경 
 *  
 */
@Controller
@RequestMapping({"","/"})
public class UserController {
	

	@Autowired
	UserService userService;
	
	@Autowired
	MailService mailService;
	
	// 의존성 주입하고 사용
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 지금은 해당 url을 스프링 시큐리티가 가로체채고 있다 - SecurityConfig 파일이 작동을 하지 않아서 이 메소드로 올수 있다
	@GetMapping("/loginForm")
	public String loginForm(@AuthenticationPrincipal PrincipalDetails vo) {
		System.out.println("로그 아웃됨 : " + vo);
		return "user/loginForm";
	}
	
	@GetMapping("/loginForm/{key}")
	public String joinForm(
			@PathVariable("key") String key,
			Model model) {
		System.out.println(key);
		
		// 이메일 인증으로 들어온 키값으로 사용자가 있는지 확인 (name과 email 가져옴)
		UserVo authUser = userService.findUserBykey(key);
		
		if(authUser != null) {
			userService.updateUserAuth(authUser);
		}
		
		
		System.out.println("authUser : " + authUser);
		
		return "user/login";
	}
	
	@GetMapping("/faillogin")
	public String faillogin(Model model) {
		System.err.println("로그인 실패");
		model.addAttribute("result", "fail");
		return "user/login";
	}
	
	@GetMapping("/loginsuccess")
	public String loginsuccess(@AuthenticationPrincipal PrincipalDetails vo, Model model) {
		model.addAttribute("authUser", vo.getUsername());
		System.out.println("유저 이메일"+vo.getUsername());
		return "user/loginsuccess";
	}

	@GetMapping("/joinForm")
	public String joinForm(@ModelAttribute UserVo vo) {
		return "user/join";
	}
	
	@RequestMapping("/mail")
	public String email() {
		return "user/email";
	}
	
//	@RequestMapping(value="/join", method = RequestMethod.POST)
//	public String join(
//			@ModelAttribute @Valid UserVo userVo, 
//			BindingResult result, 
//			Model model) {
//		
//		// 발리데이션을 위한 설정
//		if(result.hasErrors()) {
//			model.addAllAttributes(result.getModel());
//			return "user/join";
//		}
//		
//		// 비밀번호 해싱
//		userVo.setUserPassword(bCryptPasswordEncoder.encode(userVo.getUserPassword()));
//		
//		// 이메일 보내기
//		try {
//			String key = new TempKey().getKey(50, false);
//			userVo.setUserKey(key);
//			userService.addUser(userVo);
//			try {
//				mailService.mailSend(userVo.getUserEmail(), key);
//			} catch (UnsupportedEncodingException e) {
//				e.printStackTrace();
//			}
//		} catch (MessagingException e) {
//			e.printStackTrace();
//		}
//		
//		System.out.println("[userVo]:"+userVo);
//		return "redirect:/joinsucces";
//	}
	
	@GetMapping("/joinsucces")
	public String joinsucces() {
		return "user/joinsuccess";
	}
}
