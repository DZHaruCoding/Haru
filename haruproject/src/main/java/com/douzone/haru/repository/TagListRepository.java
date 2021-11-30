package com.douzone.haru.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.TagListVo;

@Repository
public class TagListRepository {
	
	@Autowired
	private SqlSession sqlSession;
	public List<TagListVo> selectTagList() {
		return sqlSession.selectList("taglist.selectTagList");
	}
	public int tagInsert(TagListVo tagListVo) {
		return sqlSession.insert("taglist.insertTagList", tagListVo);
		
	}
	public int tagDelete(Long tagNo) {
		int tagTask = sqlSession.delete("taglist.deletAllTaskTag", tagNo);
		int tagList = sqlSession.delete("taglist.deleteTagList", tagNo);
		return tagList  + tagTask ;
	}
	public int taskTagInsert(TagListVo tagListVo) {
		return sqlSession.insert("taglist.insertTaskTag", tagListVo);
	}
	public int taskTagDelete(TagListVo tagListVo) {
		return sqlSession.delete("taglist.deleteTaskTag", tagListVo);
	}

}