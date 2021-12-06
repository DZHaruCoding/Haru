package com.douzone.haru.controller.api;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.CalendarService;


@RestController
public class ApiCalendarController {
	
	@Autowired
	CalendarService calendarService;
	
	@GetMapping("/api/calendar/{authUserNo}")
	public void calendarMainSelect(@PathVariable("authUserNo") Long authUserNo) {
		Map<String, Object> map = new HashMap<String, Object>();
		map = calendarService.calendarMainSelect(authUserNo);
	}
}
