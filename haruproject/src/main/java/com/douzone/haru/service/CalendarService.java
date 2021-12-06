package com.douzone.haru.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.CalendarRepository;
import com.douzone.haru.vo.ScheduleVo;

@Service
public class CalendarService {
	
	@Autowired
	CalendarRepository calendarRepository;

	public Map<String, Object> calendarMainSelect(Long authUserNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<ScheduleVo> scheduleList = calendarRepository.calendarMainselect(authUserNo);
		for(ScheduleVo scheduleVo : scheduleList) {
			map.put("scheduleNo", scheduleVo.getScheduleNo());
			map.put("scheduleUserNo", scheduleVo.getUserNo());
			map.put("scheduleStart", scheduleVo.getScheduleStart());
			map.put("scheduleEnd", scheduleVo.getScheduleEnd());
			map.put("scheduleContents", scheduleVo.getScheduleContents());
			System.out.println("제바라아아아알 : "+map);
		}
		return map;
	}
	
	
}
