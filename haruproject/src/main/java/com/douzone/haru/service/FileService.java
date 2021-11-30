package com.douzone.haru.service;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Calendar;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.douzone.haru.repository.FileRepository;
import com.douzone.haru.vo.FileVo;

@Service
public class FileService {
	private static String SAVE_PATH="/upload-haru";
	private static String URL_BASE = "/assets/upimages";
	
	@Autowired
	private FileRepository fileRepository;

	public FileVo fileUpLoad(MultipartFile file, Long taskNo, String userName) {
		// TODO Auto-generated method stub
		try {
			//SAVE 파일 생성
			File uploadDirectory = new File(SAVE_PATH);
			if(!uploadDirectory.exists()) {
				uploadDirectory.mkdir();
			}
			
			//파일 없을 시 
			if(file.isEmpty()) {
				throw new RuntimeException("file upload error: image empty");
			}

			String originFilename = file.getOriginalFilename();
			String extName = originFilename.substring(originFilename.lastIndexOf('.')+1);
			String saveFilename = generateSaveFilename(extName);

			byte[] data = file.getBytes();
			OutputStream os = new FileOutputStream(SAVE_PATH + "/" + saveFilename);
			os.write(data);
			os.close();

			FileVo vo = new FileVo();
			vo.setFilePath(URL_BASE + "/" + saveFilename);
			vo.setTaskNo(taskNo);
			vo.setOriginName(originFilename);
			vo.setChangeName(saveFilename);
			vo.setFileState("T");
			vo.setFileMaker(userName);
			
			return fileRepository.fileUpLoad(vo);
			
		} catch(IOException ex) {
			throw new RuntimeException("file upload error:" + ex);
		}	
	}
	private String generateSaveFilename(String extName) {
		String filename = "";

		Calendar calendar = Calendar.getInstance();

		filename += calendar.get(Calendar.YEAR);
		filename += calendar.get(Calendar.MONTH);
		filename += calendar.get(Calendar.DATE);
		filename += calendar.get(Calendar.HOUR);
		filename += calendar.get(Calendar.MINUTE);
		filename += calendar.get(Calendar.SECOND);
		filename += calendar.get(Calendar.MILLISECOND);
		filename += ("." + extName);

		return filename;
	}
	//파일 생성 끝
}
