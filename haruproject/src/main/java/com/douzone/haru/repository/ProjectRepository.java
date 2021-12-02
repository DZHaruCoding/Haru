package com.douzone.haru.repository;


import java.util.List;


import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.ProjectVo;

@Repository
public class ProjectRepository {

	@Autowired
	private SqlSession sqlSession;
	
	//프로젝트 생성(깡통)
	//selectkey를 사용하면 리턴값은 1이지만 projectvo에 추가된 no값 포함해서 vo에 담김
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

	//로그인한 유저(O) 프로젝트 생성
	public void ownerProjectInsert(ProjectVo projectvo) {
		// TODO Auto-generated method stub
		sqlSession.insert("project.ownerprojectinsert",projectvo);
	}

	//프로젝트 멤버 추가
	public void memberProjectInsert(Map<String, Object> map) {
		// TODO Auto-generated method stub
		sqlSession.insert("project.memberprojectinsert",map);
	}
	
	
}
