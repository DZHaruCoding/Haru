package com.douzone.haru.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.CalendarVo;

@Repository
public class CalendarRepository {

	@Autowired
	SqlSession sqlSession;
	
	//스케줄 리스트
	public List<CalendarVo> calendarMainselect(Long authUserNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("schedule.findAll",authUserNo);
	}
	
	//개인 일정 추가
	public CalendarVo ScheduleAdd(CalendarVo calendarvo) {
		// TODO Auto-generated method stub
			sqlSession.insert("schedule.calendarscheduleadd",calendarvo);
		return calendarvo; 
	}

	//개인 일정 상세보기
	public CalendarVo ScheduleDetail(Long scheduleNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectOne("schedule.calendarscheduledetail",scheduleNo);
	}

	public Map<String, Object> ScheduleUpdate(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.update("schedule.calendarscheduleupdate",map);
//		System.out.println("변경된 map?? : "+map); 확인o / 수정된 값 넘어옴
		return map; 
	}
}
