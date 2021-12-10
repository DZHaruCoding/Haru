package com.douzone.haru.controller.api;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
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

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/tasklist")
public class ApiTasklistController {
	
	@Autowired
	private TasklistService tasklistService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private SimpMessagingTemplate template;
	
	@Autowired
	private ApiNoticeSocket apiNoticeSocket;
	
	// 테스크리스트 가져오기
	//@MessageMapping("test")
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
			Map<String, Object> map = new HashMap<String, Object>();
			
//			apiNoticeSocket.testSend(map);
			
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("생성 실패");
		}

	}
	
	@PostMapping("/delete")
	@Transactional
	public JsonResult deleteTaskList(@RequestBody long no) {
		
		long result1 = tasklistService.deleteTaskList(no);
		long result2 = taskService.deleteByTaskList(no);
		
		if (result1 > 0) {
			return JsonResult.success(result1);
		} else {
			return JsonResult.fail("삭제 실패");
		}
		
	}
	
}
