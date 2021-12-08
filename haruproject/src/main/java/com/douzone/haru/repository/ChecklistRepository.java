package com.douzone.haru.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.CheckListVo;
//종윤
@Repository
public class ChecklistRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public long insertChecklist(CheckListVo vo) {
		return sqlSession.insert("checklist.insertChecklist", vo);
	}
	
	public long deleteChecklist(CheckListVo vo) {
		return sqlSession.delete("checklist.deleteChecklist", vo);
	}
	
	public int updateChecklist(CheckListVo checklistVo) {
		return sqlSession.update("tasksetting.updateChecklist", checklistVo);
	}
	
	public List<CheckListVo> selectCheckList(Long taskNo) {
		return sqlSession.selectList("checklist.selectCheckList",taskNo);
	}
}
