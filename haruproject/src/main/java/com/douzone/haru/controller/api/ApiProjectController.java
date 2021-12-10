package com.douzone.haru.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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
	@PostMapping("/add/{authUserNo}")
	public JsonResult ProjectInsert(@PathVariable("authUserNo")Long authUserNo, @RequestBody ProjectVo projectVo) {
		ProjectVo insertProjectVo = projectService.ProjectInsert(authUserNo,projectVo);
		System.out.println("생성 확인 : "+insertProjectVo);
		return JsonResult.success(insertProjectVo);
	}
	
	//내가 속한 프로젝트 출력(Main)
	@GetMapping("/{authUserNo}")
	public JsonResult ProjectMainSelect(@PathVariable("authUserNo") Long authUserNo) {
		System.out.println("fetch 요청 됫니~~~~~~~~~~~~~~~`"+authUserNo);
		List<ProjectVo> projectlist = projectService.projectMainselect(authUserNo);
		return JsonResult.success(projectlist);
	}
	
	//프로젝트 상세보기
	@GetMapping("/detail/{projectNo}")
	public void projectDetail(@PathVariable("projectNo")Long projectNo) {
		projectService.projectDetail(projectNo);
	}
}