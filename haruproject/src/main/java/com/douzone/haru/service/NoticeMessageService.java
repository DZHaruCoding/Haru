package com.douzone.haru.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.NoticeMessageRepository;
import com.douzone.haru.vo.NoticeMessageVo;

@Service
public class NoticeMessageService {
	
	@Autowired
	NoticeMessageRepository noticeMessageRepository;
	
	public List<NoticeMessageVo> myNoticeSelect(long userNo) {
		return noticeMessageRepository.mynoticeSelect(userNo);
	}
}
