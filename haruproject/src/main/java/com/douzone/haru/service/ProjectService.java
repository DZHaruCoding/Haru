package com.douzone.haru.service;

import java.util.HashMap;
import java.util.Map;

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
		projectVo.setProjectTitle("settest4");
		projectVo.setProjectDesc("settest4");
		projectVo.setProjectStart("2021-12-01 00:00:00");
		projectVo.setProjectEnd("2021-12-31 01:00:00");
		projectVo.setProjectState("T");
		projectVo.setProjectRegDate("2021-11-30 20:42:00");
		System.out.println("======="+projectVo+"==========");
//		1.프로젝트 생성 완료
		//selectKey를 사용하면 return값은 1이고 vo에 project no값이 자동으로 들어감
		int projectNo = projectRepository.procjectInsert(projectVo);
//		2.로그인된 유저 생성된 프로젝트 삽입
		Map<String, Object> map = new HashMap<String, Object>();
		projectVo.setUserNo(1L);
		map.put("userNo",projectVo.getUserNo());
		map.put("projectNo", projectVo.getProjectNo());
		
		projectRepository.userProjectInsert(map);
		
	}
	
}
