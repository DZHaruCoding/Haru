package com.douzone.haru.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.ProjectRepository;
import com.douzone.haru.vo.ProjectVo;
import com.douzone.haru.vo.UserVo;

@Service
public class ProjectService {
	
	@Autowired
	private ProjectRepository projectRepository;

	//프로젝트 생성
	public void ProjectInsert() {
		// TODO Auto-generated method stub
		ProjectVo projectVo = new ProjectVo();
		projectVo.setProjectTitle("test11");
		projectVo.setProjectDesc("test11");
		projectVo.setProjectStart("2021-12-01 00:00:00");
		projectVo.setProjectEnd("2021-12-31 01:00:00");
		projectVo.setProjectState("T");
		projectVo.setProjectRegDate("2021-11-30 20:42:00");
		System.out.println("======="+projectVo+"==========");
		//프로젝트 생성 완료 (깡통)
		projectRepository.procjectInsert(projectVo);
		projectVo.setUserNo(1L);
		
		//O권한을 가진 유저(프로젝트 생성자) 프로젝트에 insert 
		projectRepository.ownerProjectInsert(projectVo);
		
		//프로젝트에 member 추가
		List<UserVo> userVo = new ArrayList<UserVo>();
		userVo.add(new UserVo(1L));
		userVo.add(new UserVo(2L));
		projectVo.setMembers(userVo);
		
		Map<String, Object> map = new HashMap<String, Object>();
		for(UserVo members : projectVo.getMembers()) {
			map.put("userNo", members.getUserNo());
			map.put("projectNo", projectVo.getProjectNo());
			System.out.println("map : "+map);
			projectRepository.memberProjectInsert(map);			
		}

	}
	
}
