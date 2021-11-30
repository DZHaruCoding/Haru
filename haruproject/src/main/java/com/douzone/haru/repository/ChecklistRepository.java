package com.douzone.haru.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.ChecklistVo;
import com.douzone.haru.vo.HistoryVo;

@Repository
public class ChecklistRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public long insertChecklist(ChecklistVo vo) {
		return sqlSession.insert("checklist.checklistAdd", vo);
	}
	
	public long deleteChecklist(ChecklistVo vo) {
		return sqlSession.delete("checklist.checklistDelete", vo);
	}
}
