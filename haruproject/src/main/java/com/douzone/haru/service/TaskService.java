package com.douzone.haru.service;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.TaskRepository;
import com.douzone.haru.vo.TaskVo;

@Service
public class TaskService {
	@Autowired
	TaskRepository taskRepository;
	
	public List<TaskVo> taskBytaskList(Map<String, Object> map) {
		return taskRepository.taskAllSelect(map);
	}
}
