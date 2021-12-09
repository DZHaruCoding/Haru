package com.douzone.haru.repository;

import java.util.HashMap;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.CheckListVo;
import com.douzone.haru.vo.TagListVo;
import com.douzone.haru.vo.TaskUserVo;
import com.douzone.haru.vo.TaskVo;

/*
 * 작성자 : 이종윤
 * 설명   : Task Setting
*/
@Repository
public class TaskSettingRepository {
	
	@Autowired
	private SqlSession sqlSession;
	
	//업무 내용 수정
	public int updateTaskContents(TaskVo taskVo) {
		return sqlSession.update("tasksetting.updateTaskContents", taskVo);
	}
	
	//업무 날짜 변경
	public int taskDateUpdate(TaskVo taskVo) {
		return sqlSession.update("tasksetting.taskDateUpdate", taskVo);
	}
	
	
	//업무 라벨 수정
	public int updateTaskLabel(Long taskNo, String color) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("taskNo", taskNo);
		map.put("color", color);
		
		return sqlSession.update("tasksetting.updateTaskLabel",map);
	}

}
