package com.douzone.haru.service;

import java.util.List;
import java.util.Map;

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
	
	public long noticeCheck(Map<String, Object> map) {
		return noticeMessageRepository.noticeCheck(map);
	}
	
	public long noticeAllCheck(long userNo) {
		return noticeMessageRepository.noticeAllCheck(userNo);
	}
}
