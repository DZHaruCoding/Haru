package com.douzone.haru.controller.api;

import java.io.UnsupportedEncodingException;

import javax.mail.MessagingException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.haru.config.auth.PrincipalDetails;
import com.douzone.haru.config.auth.scurity.AuthUser;
import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.exception.ImgUploadServiceException;
import com.douzone.haru.service.UserService;
import com.douzone.haru.service.email.MailService;
import com.douzone.haru.util.TempKey;
import com.douzone.haru.vo.UserVo;

/*
 * 작성자 : 이승현
 *  - 회원가입, 아이디 중복 체크, 
 */
@RestController
@RequestMapping("/user")
public class ApiUserController {

	@Autowired
	private UserService userService;

	@Autowired
	private MailService mailService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	
	// 세션에 담긴 사용자 테스트 컨트롤러
	@GetMapping("/test")
	public @ResponseBody JsonResult test(@AuthUser PrincipalDetails principalDetails) {
		return JsonResult.success(principalDetails.getUserVo());
	}
	
	@PostMapping("/join")
	public JsonResult join(@RequestBody UserVo userVo) {
		System.out.println("회원가입 누름");
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
	// 유저정보 찾는 핸들러
	@PostMapping("/findUserProfile")
	public JsonResult findUserProfile(@RequestBody UserVo vo) {
		System.out.println("[유저 찾는] : " + vo);
		UserVo userVo =new UserVo();
		userVo =userService.findUserProfile(vo.getUserEmail());
		System.out.println(userVo);
		return JsonResult.success(userVo);
	}
	// 프로필 수정 핸들러
	@PostMapping("/ChangeProfile")
	public JsonResult ChangeProfile(@RequestBody UserVo vo) {
		System.out.println(vo);
		System.out.println("프로필 수정중...");
		boolean data = userService.updateProfile(vo);
		System.out.println("tlfvo");
		System.out.println(data);
		return JsonResult.success(data);
	}
	
	@PostMapping("/uploadfile")
	public JsonResult uploadingImf(
			@AuthUser PrincipalDetails vo,
			@RequestParam(value = "userfile", required = false) MultipartFile multipartFile) {
		System.out.println("멀티   " + multipartFile);
		System.out.println(vo);
		System.err.println("[ 세션에 사용자 있음 ]" + vo.getUsername());
		UserVo userVo = new UserVo();
		userVo.setUserEmail(vo.getUsername());
		try {	
			System.out.println("---이미지 업로드중 ---");
			String uploadImg = userService.ImageUpload(multipartFile);
			System.out.println("--- 성공 업로드중 ---");
			userVo.setUserPhoto(uploadImg);
		}catch(ImgUploadServiceException e){
			System.out.println("이미지가 업로드 되지 않았습니다");
		}
		
		boolean result = userService.updateProfileImg(userVo);;
		
		return JsonResult.success(result);
	}
	
	// 비밀번호 찾기 헨들러
	@PostMapping("/findPassword")
	public JsonResult findPassword(@RequestBody String email) {

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
