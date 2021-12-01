package com.douzone.haru.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.ProjectVo;

@Repository
public class ProjectRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//프로젝트 통 생성(유저x)
	public int procjectInsert(ProjectVo projectvo) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("project.projectinsert",projectvo);
		return result;
	}

	//로그인된 유저 생성된 프로젝트 삽입
	public int userProjectInsert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		int result = sqlSession.insert("project.userprojectinsert",map);
		return result;
	}
	
	
}
