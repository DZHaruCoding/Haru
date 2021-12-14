package com.douzone.haru.controller.api;

import java.util.List;
import java.util.Map;

import org.json.simple.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.dto.JsonResult;
import com.douzone.haru.service.HistoryService;
import com.douzone.haru.vo.HistoryVo;

@CrossOrigin(origins = { "http://localhost:8080" })
@RestController
public class ApiHistoryController {
	@Autowired
	private SimpMessagingTemplate template;
	@Autowired
	private HistoryService historyService;

	@GetMapping("/api/history/{projectNo}")
	public JsonResult selectHistory(@PathVariable("projectNo") Long projectNo) {
		List<HistoryVo> log = historyService.selectHistory(projectNo);
		return JsonResult.success(log);
	}

	/*
	 * 작성자:김우경 설명:히스토리추가
	 */
	@PostMapping("/api/history/insertHistory")
	public JsonResult insertHistory(@RequestBody JSONObject historyJson) {

		boolean result = historyService.insertHistory(historyJson);
		List<HistoryVo> log = historyService.selectHistory(Long.parseLong((String) (historyJson.get("projectNo"))));

		return JsonResult.success(result ? log : -1);
	}
	
	@MessageMapping("/history/all") // react에서 보내면 spring 수신
//	@SendTo("/topic/all")	// spring -> react 송신
	public void socketHistory(Map<Object, Object> socketData) {
/*		
  *  senderNo: senderNo, // 보내는사람 한명
   * senderName: senderName,
   * receiver: userArray, // 받는사람 여러명
  *  historyType: historyType,
  *  historyDate: moment(new Date()).format('YYYY-MM-DD HH:mm:ss'),
  *  actionName: actionName, // 행위
  *  projectNo: projectNo,
  *  authUserNo: sessionStorage.getItem('authUserNo')
 */
		List memberList = (List) socketData.get("receiver"); //받는사람리스트 꺼내고 그리스트 만큼 반복한다
		for(int i=0; i < memberList.size();i++) {
		
			//spring -> react 송신
			template.convertAndSend("/topic/history/all/"+memberList.get(i), socketData);
		}
	}
}
