package com.douzone.haru.controller.api;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.TaskService;
import com.douzone.haru.vo.TaskListVo;
import com.douzone.haru.vo.TaskVo;

@RestController
@RequestMapping("/api/task")
public class ApiTaskController {
	@Autowired
	TaskService taskService;
	
	@PostMapping("dropTask")
	public JsonResult dropTask(@RequestBody TaskListVo vo) {
		long result = taskService.taskDropUpdate(vo);

		if (result > 0) {
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("데이터 업데이트 실패");
		}
		
	}
	
	@PostMapping("add")
	public JsonResult taskAdd(@RequestBody TaskVo vo) {
		long result = taskService.insertTask(vo);
		
		if (result > 0) {
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("데이터 추가 실패");
		}
	}
}
