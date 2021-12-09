package com.douzone.haru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.FileRepository;
import com.douzone.haru.vo.FileVo;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	
	public void uploadFile(FileVo fileVo,
							  Long userNo, 
							  Long taskNo) {
		fileVo.setTaskNo(taskNo);
		fileVo.setFileMaker(fileRepository.findNameByNo(userNo));
		fileRepository.insertFile(fileVo);
	}

	public String getFile(Long fileNo) {
		return fileRepository.findByFileNo(fileNo);
	}
	
	
}
