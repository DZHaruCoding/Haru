package com.douzone.haru.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.TaskService;
import com.douzone.haru.service.TasklistService;
import com.douzone.haru.vo.TaskListVo;

@RestController
@RequestMapping("/api/tasklist")
public class ApiTasklistController {
	
	@Autowired
	TasklistService tasklistService;
	
	@Autowired
	TaskService taskService;
	
	// 테스크리스트 가져오기
	@GetMapping("/data/{projectNo}")
	@Transactional
	public JsonResult selectTasklist(@PathVariable long projectNo ) {
		List<TaskListVo> list = tasklistService.selectTaskList(projectNo);
		
		for (TaskListVo item : list) {
			Map<String, Object> map = new HashMap<String, Object>();
			
			map.put("projectNo", item.getProjectNo());
			map.put("tasklistNo", item.getTaskListNo());
			
			item.setTaskVoList(taskService.taskBytaskList(map));
		}
		
		return JsonResult.success(list);
	}
	
	@PostMapping("/add")
	public JsonResult insertTaskList(@RequestBody TaskListVo vo) {
		
		long result = tasklistService.insertTaskList(vo);
		
		if (result > 0) {
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("생성 실패");
		}

	}
	
}
