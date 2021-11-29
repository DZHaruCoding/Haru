package com.douzone.haru.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.TaskListVo;

@Repository
public class TaskListRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public long insertTaskList(TaskListVo vo) {
		return sqlSession.insert("tasklist.taskListAdd", vo);
	}
	
	public long deleteTaskList(TaskListVo vo) {
		return sqlSession.update("tasklist.taskListDelete", vo);
	}
}
