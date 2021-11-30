package com.douzone.haru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.ProjectRepository;
import com.douzone.haru.vo.ProjectVo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	//프로젝트 생성
	public void ProjectInsert(ProjectVo projectVo) {
		// TODO Auto-generated method stub
		projectRepository.procjectInsert(projectVo);
	}
	
}
