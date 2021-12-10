package com.douzone.haru.repository;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.NoticeMessageVo;

@Repository
public class NoticeMessageRepository {
	@Autowired
	private SqlSession sqlSession;
	
	public List<NoticeMessageVo> mynoticeSelect(long userNo) {
		return sqlSession.selectList("notice.myNotice", userNo);
	}
}
