package com.douzone.haru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.FileRepository;
import com.douzone.haru.vo.FileVo;

@Service
public class FileService {

	@Autowired
	private FileRepository fileRepository;
	
	public boolean insertFile(FileVo fileVo, Long userNo) {
		int file = fileRepository.insertFile(fileVo);
		return file == 1;
	}

	public String findByFileNo(Long fileNo) {
		return fileRepository.findByFileNo(fileNo);
	}
	
}
