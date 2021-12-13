package com.douzone.haru.controller.api;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.UserService;
import com.douzone.haru.service.email.MailService;
import com.douzone.haru.vo.UserVo;

/*
 * 작성자 : 이승현
 *  - 회원가입, 아이디 중복 체크, 
 */
@RestController
@RequestMapping("/api/user")
public class ApiUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@PostMapping("/checkemail")
	public JsonResult checkid(@RequestParam(value = "email") String email) {

		String userid = email;
		UserVo userVo = userService.findByUsername(userid);
		System.out.println(userVo);

		return JsonResult.success(userVo != null);
	}

	
	// 비밀번호 찾기 헨들러
	@PostMapping("/findPassword")
	public JsonResult findPassword(@RequestParam("email") String email) {

		// 모달창에 입력된 id의 email 가져오기
		UserVo vo = userService.findEmailById(email);

		String date = "";

		if (vo != null) {
			// 존제하지 않는 이메일 이면
			// 존제하는 이메일일 경우 해당 이메일로 이메일 보내기
			try {
				// 이메일 서비스로 메일 보내기
				mailService.mailSendPassword(vo.getUserEmail(), vo.getUserName());
			} catch (UnsupportedEncodingException | MessagingException e) {
				e.printStackTrace();
			}
			date = vo.getUserEmail();
		} else {
			date = "fail";
		}

		return JsonResult.success(date);
	}
	
	

}
