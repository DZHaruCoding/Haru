package com.douzone.haru.repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.ScheduleVo;

@Repository
public class CalendarRepository {

	@Autowired
	SqlSession sqlSession;
	
	//스케줄 리스트
	public List<ScheduleVo> calendarMainselect(Long authUserNo) {
		// TODO Auto-generated method stub
		return sqlSession.selectList("schedule.findAll",authUserNo);
	}
	
}
