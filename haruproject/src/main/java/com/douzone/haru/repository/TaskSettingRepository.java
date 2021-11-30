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
	
	public int insertChecklist(CheckListVo checklistVo) {
		return sqlSession.insert("tasksetting.insertChecklist", checklistVo);
	}

	public int updateChecklist(CheckListVo checklistVo) {
		return sqlSession.update("tasksetting.updateChecklist", checklistVo);
	}

	public int deleteChecklist(Long checklistNo) {
		return sqlSession.delete("tasksetting.deleteChecklist", checklistNo);
	}

	public int updatePoint(TaskVo taskVo) {
		return sqlSession.update("tasksetting.updatePoint", taskVo);
	}

	public int updateTaskContents(TaskVo taskVo) {
		return sqlSession.update("tasksetting.updateTaskContents", taskVo);
	}
	
	/*
	 * 작성자 : 최인효
	 * 설명 : 업무 날짜 변경
	 */
	public int taskDateUpdate(TaskVo taskVo) {
		return sqlSession.update("kanbanBoard.taskDateUpdate", taskVo);
	}
	
	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 멤버 추가
	 */
	public int taskUserInsert(TaskUserVo taskUserVo) {
		return sqlSession.insert("kanbanBoard.insertTaskUser",taskUserVo);
	}
	
	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 멤버 삭제
	 */
	public int taskUserDelete(TaskUserVo taskUserVo) {
		return sqlSession.delete("kanbanBoard.deleteTaskUser", taskUserVo);
	}
	
	/*
	 * 작성자 : 김우경
	 * 설명 : 업무 라벨 수정
	 */
	public int updateTaskLabel(Long taskNo, String color) {
		Map<String, Object> map = new HashMap<>();
		
		map.put("taskNo", taskNo);
		map.put("color", color);
		
		return sqlSession.update("tasksetting.updateTaskLabel",map);
	}

	public int updateTag(TagListVo taglistVo) {
		return sqlSession.update("tasksetting.updateTag", taglistVo);
	}
	
	public int taskMemberDelete(Long userNo, Long taskNo) {
		Map<Object, Long> map = new HashMap<>();
		map.put("userNo", userNo);
		map.put("taskNo", taskNo);
		return sqlSession.delete("kanbanBoard.deleteTaskMember", map);
	}
}