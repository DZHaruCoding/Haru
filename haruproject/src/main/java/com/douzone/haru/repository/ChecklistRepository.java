package com.douzone.haru.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.CheckListVo;

@Repository
public class ChecklistRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public long insertChecklist(CheckListVo vo) {
		return sqlSession.insert("checklist.checklistAdd", vo);
	}
	
	public long deleteChecklist(CheckListVo vo) {
		return sqlSession.delete("checklist.checklistDelete", vo);
	}
}
