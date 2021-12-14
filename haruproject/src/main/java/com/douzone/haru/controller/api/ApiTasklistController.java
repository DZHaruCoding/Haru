package com.douzone.haru.controller.api;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.config.auth.PrincipalDetails;
import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.NoticeMessageService;
import com.douzone.haru.service.ProjectService;
import com.douzone.haru.service.TaskService;
import com.douzone.haru.service.TasklistService;
import com.douzone.haru.service.tagListService;
import com.douzone.haru.vo.MessageBoxVo;
import com.douzone.haru.vo.NoticeMessageVo;
import com.douzone.haru.vo.TaskListVo;
import com.douzone.haru.vo.TaskVo;
import com.douzone.haru.vo.UserVo;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

@CrossOrigin(origins = { "http://localhost:3000" })
@RestController
@RequestMapping("/api/tasklist")
public class ApiTasklistController {
	
	@Autowired
	private TasklistService tasklistService;
	
	@Autowired
	private TaskService taskService;
	
	@Autowired
	private tagListService tagListService;
	
	@Autowired
	private NoticeMessageService noticeMessageService;
	
	@Autowired
	private ProjectService projectService;
	
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
			
			
			for (TaskVo taskVo : item.getTaskVoList()) {
				taskVo.setTagListVo(tagListService.selectTag(taskVo.getTaskNo()));
			}
		}
	
		
		return JsonResult.success(list);
	}
	
//	@AuthenticationPrincipal PrincipalDetails userVo,
	@PostMapping("/add")
	public JsonResult insertTaskList(@RequestBody Map<String, Object> vo) {
		
//		System.out.println(user.getUserNo());
		
		TaskListVo tlVo = new TaskListVo();
		tlVo.setProjectNo((Integer)vo.get("projectNo"));
		tlVo.setTaskListName((String)vo.get("taskListName"));
		tlVo.setTaskListOrder((Integer)vo.get("taskListOrder"));
		
		String userEmail = (String)vo.get("userEmail");
		
		long result = tasklistService.insertTaskList(tlVo);
		if (result > 0) {
			Map<String, Object> map = new HashMap<String, Object>();
			map.put("message", "테스크 리스트가 추가되었습니다.");
			map.put("projectNo", tlVo.getProjectNo());
			map.put("userEmail", userEmail);
			
			// 알림 추가
			String message = ((String) vo.get("projectName")) + "에 테스크 리스트가 추가되었습니다.";
			NoticeMessageVo messageVo = new NoticeMessageVo();
			messageVo.setNoticeMessage(message);
			messageVo = noticeMessageService.noticeInsert(messageVo);
			
			// 맴버들에게 알림
			List<UserVo> member = projectService.proejctmemberAlllistselect(tlVo.getProjectNo());
			
			for (UserVo userVo : member) {
				if (!userVo.getUserEmail().equals(userEmail)) {
					MessageBoxVo mbVo = new MessageBoxVo();
					mbVo.setUserNo(userVo.getUserNo());
					mbVo.setNoticeNo(messageVo.getNoticeNo());
					
					noticeMessageService.noticeBoxInsert(mbVo);
				}
			}
			
			Map<String, Object> resultSend = new HashMap<String, Object>();
			resultSend.put("data", vo);
			resultSend.put("bell", message);
			
			apiNoticeSocket.taskUpdateSend(resultSend, member, userEmail);
			
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
