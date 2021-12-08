package com.douzone.haru.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.annotation.RequestScope;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.CalendarService;
import com.douzone.haru.vo.CalendarVo;


@RestController
@RequestMapping("/api/calendar")
public class ApiCalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	@GetMapping("/{authUserNo}")
	public void calendarMainSelect(@PathVariable("authUserNo") Long authUserNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = calendarService.calendarMainSelect(authUserNo);
	}
	
	//개인 일정 추가
	@PostMapping("/add")
	public JsonResult ScheduleAdd(@RequestBody CalendarVo calendarVo) {
		System.out.println("/add api 요청 들어옴?? 들어온 데이터 "+ calendarVo);
		CalendarVo calendaraddVo = calendarService.ScheduleAdd(calendarVo);
		return JsonResult.success(calendaraddVo);
	}
	//개인 일정 상세보기
	@GetMapping("/detail/{scheduleNo}")
	public JsonResult ScheduleDetail(@PathVariable("scheduleNo")Long scheduleNo) {
		CalendarVo calendarVo = calendarService.ScheduleDetail(scheduleNo);
		System.out.println("개인 일정 상세보기 : "+calendarVo);
		return JsonResult.success(calendarVo);
	}
	//개인 일정 수정
	@PutMapping("/update/{scheduleNo}")
	public JsonResult ScheduleUpdate(@PathVariable("scheduleNo")Long scheduleNo,
			@RequestBody CalendarVo calendarVo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = calendarService.ScheduleUpdate(scheduleNo,calendarVo);
		return JsonResult.success(map);
	}
}
