package com.douzone.haru.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.NoticeMessageService;
import com.douzone.haru.vo.NoticeMessageVo;

@RestController
@RequestMapping("/api/notice")
public class ApiNoticeMessageController {

	@Autowired
	NoticeMessageService noticeMessageService;
	
	@PostMapping("/getMyNotice")
	public JsonResult myNoticeSelect(@RequestBody long userNo) {
		List<NoticeMessageVo> list = noticeMessageService.myNoticeSelect(userNo);
		
		return JsonResult.success(list);
	}
}
