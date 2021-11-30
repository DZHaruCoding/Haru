package com.douzone.haru.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.ProjectVo;

@Repository
public class ProjectRepository {

	@Autowired
	private SqlSession sqlSession;

	public void procjectInsert(ProjectVo projectvo) {
		// TODO Auto-generated method stub
		sqlSession.insert("project.projectinsert",projectvo);
	}
	
	
}
