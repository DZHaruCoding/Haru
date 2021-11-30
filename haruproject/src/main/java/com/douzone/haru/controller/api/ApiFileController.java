package com.douzone.haru.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.FileService;
import com.douzone.haru.vo.FileVo;

@RestController
public class ApiFileController {
	
	@Autowired
	private FileService fileService;
	
	@PostMapping("/api/upload")
	public JsonResult fileUpLoad(
			@RequestParam("file") MultipartFile file,
			@RequestParam("taskNo") Long taskNo,
			@RequestParam("userName") String userName) {
		FileVo filevo = fileService.fileUpLoad(file,taskNo,userName);
		return JsonResult.success(filevo);
	}
	
}
