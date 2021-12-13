package com.douzone.haru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.TaskSettingRepository;
import com.douzone.haru.vo.TaskVo;

@Service
public class TaskSettingService {

	@Autowired
	private TaskSettingRepository taskSettingRepository;
	
	public int updateTaskContents(TaskVo taskVo) {
		return taskSettingRepository.updateTaskContents(taskVo);
	}
	
	public int taskDateUpdate(TaskVo taskVo) {
		return taskDateUpdate(taskVo);
	}
	
	public int updateTaskLabel(Long taskNo, String color) {
		return updateTaskLabel(taskNo, color);
	}
}
