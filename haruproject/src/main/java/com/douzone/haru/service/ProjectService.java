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
	public void ProjectInsert() {
		// TODO Auto-generated method stub
		ProjectVo projectVo = new ProjectVo();
		projectVo.setProjectTitle("settest");
		projectVo.setProjectDesc("settest");
		projectVo.setProjectStart("2021-12-01 00:00:00");
		projectVo.setProjectEnd("2021-12-31 01:00:00");
		projectVo.setProjectState("T");
		projectVo.setProjectRegDate("2021-11-30 20:42:00");
		System.out.println("======="+projectVo+"==========");
		projectRepository.procjectInsert(projectVo);
	}
	
}
