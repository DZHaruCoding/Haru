package com.douzone.haru.repository;

import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.CommentVo;

@Repository
public class CommentRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public int insertComment(CommentVo commentVo) {
		return sqlSession.insert("comment.insertComment", commentVo);
	}

	public int updateCommentContents(Map<String,Object> map) {
		return sqlSession.update("comment.updateCommentContents", map);
	}

	public int deleteComment(Long commentNo) {
		return sqlSession.delete("comment.deleteComment", commentNo);
	}

	public int insertLikeUser(Map<String, Object> map) {
		return sqlSession.insert("comment.insertLikeUser",map);
	}

}
