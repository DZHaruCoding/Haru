package com.douzone.haru.repository;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.HistoryVo;

@Repository
public class HistoryRepository {

	@Autowired
	private SqlSession sqlSession;
	
	public List<HistoryVo> selectHistory(Long projectNo) {
		return sqlSession.selectList("history.selectHistory", projectNo);
	}

	public int insertHistory(Map<String, Object> map) {
		return sqlSession.insert("history.insertHistory", map);
	}
	//이종윤이이이이리일이러인러ㅣㄴ아러ㅣㅏ러;ㅣㅏ언ㄹ;ㅣ나어리;아ㅓㄴ라;ㅣ
	//이어린아ㅓㄹㄴ아ㅣ런이ㅏ런이라ㅓㄴㅇ리ㅓㄴ이런이러
	//ㄴ이ㅏ런이ㅏ런이런이런이렁니런이러

}
