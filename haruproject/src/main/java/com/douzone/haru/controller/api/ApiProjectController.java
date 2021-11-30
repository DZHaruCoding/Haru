package com.douzone.haru.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.ProjectService;
import com.douzone.haru.vo.ProjectVo;

@RestController
@RequestMapping("/api/project")
public class ApiProjectController {

	@Autowired
	private ProjectService projectService;
	
	//프로젝트 생성
	@PostMapping("/add")
	public String ProjectInsert(ProjectVo projectVo) {
		projectService.ProjectInsert(projectVo);
		return "";
	}
	
}
