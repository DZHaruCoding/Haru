package com.douzone.haru.controller.api;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.TaskSettingService;
import com.douzone.haru.vo.CheckListVo;
import com.douzone.haru.vo.ProjectVo;
import com.douzone.haru.vo.TagListVo;
import com.douzone.haru.vo.TaskVo;
/*
 * 종윤
 */
@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
public class ApiTaskSettingController {
	
	@Autowired
	private TaskSettingService taskSettingService;
	
	/*
	 * tasksetting을 setting
	 */
	@GetMapping("/api/tasksetting/checklist/{taskNo}")
	public JsonResult tasksetting(@PathVariable("taskNo") Long taskNo) {
		List<CheckListVo> checklist = taskSettingService.selectChecklist(taskNo);
		return JsonResult.success(checklist);
	}
	
	/*
	 * checklist insert
	 */
	@PostMapping("/api/tasksetting/checklist/add")
	public JsonResult checklistInsert(@RequestBody CheckListVo checklistVo) {
		boolean result = taskSettingService.insertChecklist(checklistVo);
		return JsonResult.success(result ? checklistVo : -1);
	}
	
	/*
	 *checklist update 내용이 있으면 내용 변화, 내용이 없으면 상태 수정
	 */
	@PostMapping("/api/tasksetting/checklist/update")
	public JsonResult checklistUpdate(@RequestBody CheckListVo checklistVo) {
		boolean result = taskSettingService.updateChecklist(checklistVo);
		return JsonResult.success(result ? checklistVo : -1);
	}
	
	/*
	 * checklist delete
	 */
	@DeleteMapping("/api/tasksetting/checklist/{checklistNo}")
	public JsonResult checklistDelete(@PathVariable("checklistNo") Long checklistNo) {
		boolean result = taskSettingService.deleteChecklist(checklistNo);
		return JsonResult.success(result ? checklistNo : -1);
	}
	
//    /*
//     * 업무 내용 업데이트
//     */
//	@PostMapping("/api/tasksetting/task/{taskNo}")
//	public JsonResult taskContentsUpdate(
//			@PathVariable("taskNo") Long taskNo,
//			@RequestBody String taskContents) {
//		TaskVo taskVo = new TaskVo();
//		taskVo.setTaskNo(taskNo);
//		taskVo.setTaskContents(taskContents);
//		boolean result = taskSettingService.updateTaskContents(taskVo);
//		return JsonResult.success(result ? taskVo : -1);
//	}
//	
//	/*
//	 * 작성자 : 이종윤
//	 * 설명 : 업무 날짜 변경
//	 */
//	@PostMapping("/api/tasksetting/calendar/update")
//	public JsonResult taskDateUpdate(@RequestBody TaskVo TaskVo) {
//		boolean result = taskSettingService.taskDateUpdate(TaskVo);
//		return  JsonResult.success(result ? TaskVo : -1);
//	}
//	
//	
//	/*
//	 * 작성자:이종윤
//	 * 설명: 업무 라벨 색상 수정
//	 */
//	@PostMapping("/api/tasksetting/tasklabel/{taskNo}")
//	public JsonResult taskLabel(
//			@PathVariable("taskNo") Long taskNo,
//			@RequestBody String color) {
//		
//		
//		boolean result = taskSettingService.updateTaskLabel(taskNo, color);
//		return JsonResult.success(result ? taskNo : -1);
//	}
//	
//	/*
//	 * 작성자:김우경
//	 * 설명:태그 수정
//	 */
//	@PostMapping("/api/tasksetting/tag/update")
//	public JsonResult tagUpdate(
//			@RequestBody TagListVo taglistVo) {
//		boolean result = taskSettingService.updateTag(taglistVo);
//		return JsonResult.success(result ? taglistVo : -1);
//	}

}
