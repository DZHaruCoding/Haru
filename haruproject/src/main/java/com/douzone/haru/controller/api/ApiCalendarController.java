package com.douzone.haru.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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
	public void ScheduleAdd(CalendarVo calendarVo) {
		CalendarVo calendaraddVo = calendarService.ScheduleAdd(calendarVo);
	}
	//개인 일정 상세보기
	@GetMapping("/detail/{scheduleNo}")
	public void ScheduleDetail(@PathVariable("scheduleNo")Long scheduleNo) {
		calendarService.ScheduleDetail(scheduleNo);
	}
	//개인 일정 수정
	@GetMapping("/update/{scheduleNo}")
	public void ScheduleUpdate(@PathVariable("scheduleNo")Long scheduleNo,
			@RequestBody CalendarVo calendarVo) {
		calendarService.ScheduleUpdate(scheduleNo,calendarVo);
	}
}
