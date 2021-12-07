package com.douzone.haru.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.CalendarRepository;
import com.douzone.haru.vo.CalendarVo;

@Service
public class CalendarService {
	
	@Autowired
	CalendarRepository calendarRepository;

	public Map<String, Object> calendarMainSelect(Long authUserNo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		List<CalendarVo> scheduleList = calendarRepository.calendarMainselect(authUserNo);
		for(CalendarVo scheduleVo : scheduleList) {
			map.put("scheduleNo", scheduleVo.getScheduleNo());
			map.put("scheduleUserNo", scheduleVo.getUserNo());
			map.put("scheduleStart", scheduleVo.getScheduleStart());
			map.put("scheduleEnd", scheduleVo.getScheduleEnd());
			map.put("scheduleContents", scheduleVo.getScheduleContents());
			System.out.println("제바라아아아알 : "+map);
		}
		return map;
	}
	
	//개인 일정 추가
	public CalendarVo ScheduleAdd(CalendarVo calendarvo) {
		// TODO Auto-generated method stub
		return calendarRepository.ScheduleAdd(calendarvo);
	}

	//개인 일정 상세보기
	public void ScheduleDetail(Long scheduleNo) {
		// TODO Auto-generated method stub
		calendarRepository.ScheduleDetail(scheduleNo);
	}
	
	//개인 일정 수정
	public void ScheduleUpdate(Long scheduleNo, CalendarVo calendarvo) {
		// TODO Auto-generated method stub
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("scheduleNo", scheduleNo);
		map.put("userNo", calendarvo.getUserNo());
		map.put("scheduleStart", calendarvo.getScheduleStart());
		map.put("scheduleEnd", calendarvo.getScheduleEnd());
		map.put("scheduleContents", calendarvo.getScheduleContents());
		calendarRepository.ScheduleUpdate(map);
	}
	
	
}
