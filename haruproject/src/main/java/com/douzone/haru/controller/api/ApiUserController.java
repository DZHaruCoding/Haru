package com.douzone.haru.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.UserService;
import com.douzone.haru.vo.UserVo;

@RestController
@RequestMapping("/api/user")
public class ApiUserController {
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/join")
	public JsonResult join(UserVo vo) {
		System.out.println("[유저 정보]"+ vo);
		return JsonResult.success(userService);
	}
	
}
