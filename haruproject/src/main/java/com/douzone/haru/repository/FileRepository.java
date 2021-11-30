package com.douzone.haru.repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.douzone.haru.vo.FileVo;

@Repository
public class FileRepository {
	
	@Autowired
	private SqlSession sqlSession;

	public FileVo fileUpLoad(FileVo filevo) {
		// TODO Auto-generated method stub
		int fileNo = sqlSession.insert("file.upload",filevo);
		FileVo selectfilevo = sqlSession.selectOne("file.selectUploadSelect",fileNo);

		return selectfilevo;
	}
	
}
