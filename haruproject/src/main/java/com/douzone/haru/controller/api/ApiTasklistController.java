package com.douzone.haru.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.TasklistService;
import com.douzone.haru.vo.TaskListVo;

@RestController
@RequestMapping("/api/tasklist")
public class ApiTasklistController {
	
	@Autowired
	TasklistService tasklistService;
	
	// 테스크리스트 가져오기
	@GetMapping("/data/{projectNo}")
	public JsonResult selectTasklist(@PathVariable long projectNo ) {
		System.out.println("zzzzzz");
		List<TaskListVo> list = tasklistService.selectTaskList(projectNo);
		
		
		
		return JsonResult.success(list);
	}
	
}
