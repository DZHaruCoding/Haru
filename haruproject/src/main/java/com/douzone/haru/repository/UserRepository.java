package com.douzone.haru.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.UserVo;

@Repository
public class UserRepository {
	
	@Autowired
	SqlSession sqlSession;
	
	
	public UserVo findByUsername(String username) {
		return null;
	}

	public boolean addUser(UserVo vo) {
		 return 1 == sqlSession.insert("user.addUser", vo);
	}

}
