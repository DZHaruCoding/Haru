package com.douzone.haru.controller.api;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import com.douzone.haru.service.NoticeMessageService;
import com.douzone.haru.vo.UserVo;

@Controller
public class ApiNoticeSocket {
	
    @Autowired
	private SimpMessagingTemplate template;
    
    @Autowired
    private NoticeMessageService noticeMessageService;
    
	
	@MessageMapping("/test") // react -> spring 송신
//	@SendTo("topic/asnotice")	// spring -> react 송신
	public void testSend(Object socketData) {
		try{
			System.out.println("작동");
//			System.out.println(socketData);
			template.convertAndSend("/topic/test", socketData);
		}catch(Exception ex){
			System.out.println(ex.getMessage());
		}
	}
	
	
	@MessageMapping("kanban")
	public void taskUpdateSend(Map<String, Object> socketData, List<UserVo> userVo, String myEmail) {
		try {
			for (UserVo vo : userVo) {
				template.convertAndSend("/topic/kanban/tasklist/add", socketData);
			}
			
		} catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
}
