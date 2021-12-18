package com.douzone.haru.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.config.auth.PrincipalDetails;
import com.douzone.haru.config.auth.scurity.AuthUser;
import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.ProjectService;
import com.douzone.haru.service.TaskService;
import com.douzone.haru.vo.TaskListVo;
import com.douzone.haru.vo.TaskVo;
import com.douzone.haru.vo.UserVo;

@RestController
@RequestMapping("/api/task")
public class ApiTaskController {
	@Autowired
	TaskService taskService;
	
	@Autowired
	private ProjectService projectService;
	
	@Autowired
	private ApiNoticeSocket apiNoticeSocket;
	
	@PostMapping("/dropTask")
	public JsonResult dropTask(@RequestBody TaskListVo vo, @AuthUser PrincipalDetails principa) {
		
		long result = taskService.taskDropUpdate(vo);
		
		System.out.println("sadsaddsa" + result);
		System.out.println("sadsaddsa" + vo);
		
		if (result > 0) {
			List<UserVo> member = projectService.proejctmemberAlllistselect(vo.getProjectNo());
			
			if (member.size() == 0) {
				return JsonResult.success(result);
			}
			
			apiNoticeSocket.taskMoveSend(vo, member, principa.getUserNo());
			
			
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("데이터 업데이트 실패");
		}
		
	}
	
	@PostMapping("/add")
	public JsonResult taskAdd(@RequestBody TaskVo vo) {
		long result = taskService.insertTask(vo);
		
		if (result > 0) {
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("데이터 추가 실패");
		}
	}
	
	@PostMapping("/delete")
	public JsonResult taskDelete(@RequestBody long no) {
		long result = taskService.taskDelete(no);
		
		if (result > 0) {
			return JsonResult.success(result);
		} else {
			return JsonResult.fail("데이터 삭제 실패");
		}
	}
}
