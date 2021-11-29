package com.douzone.haru.controller.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.douzone.haru.service.ProjectService;

@RestController
public class ApiProjectController {

	@Autowired
	private ProjectService projectService;
	
	
}
