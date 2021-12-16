package com.douzone.haru.controller.api;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.config.auth.PrincipalDetails;
import com.douzone.haru.config.auth.scurity.AuthUser;
import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.UserService;
import com.douzone.haru.service.email.MailService;
import com.douzone.haru.util.TempKey;
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

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 세션에 담긴 사용자 테스트 컨트롤러
	@GetMapping("/test")
	public JsonResult test(@AuthUser PrincipalDetails principalDetails) {
		return JsonResult.success(principalDetails.getUserVo());
	}

	@PostMapping("/join")
	public JsonResult join(@RequestBody UserVo userVo) {

		// 비밀번호 해싱
		userVo.setUserPassword(bCryptPasswordEncoder.encode(userVo.getUserPassword()));

		// 이메일 보내기
		try {
			String key = new TempKey().getKey(50, false);
			userVo.setUserKey(key);
			userService.addUser(userVo);
			try {
				mailService.mailSend(userVo.getUserEmail(), key);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			}
		} catch (MessagingException e) {
			e.printStackTrace();
		}

		System.out.println("[userVo]:" + userVo);
		return JsonResult.success(userVo != null);
	}

	@PostMapping("/checkemail")
	public JsonResult checkid(@RequestBody UserVo vo) {
		UserVo userVo = userService.findByUsername(vo.getUserEmail());
		return JsonResult.success(userVo != null);

	}

	// 비밀번호 찾기 헨들러
	@PostMapping("/findPassword")
	public JsonResult findPassword(@RequestBody String email) {

		System.out.println(email);
		System.out.println("이메일 보내는중...");
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
