package com.douzone.haru.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.UserRepository;
import com.douzone.haru.vo.UserVo;

@Service
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	public boolean addUser(UserVo vo) {
		return userRepository.addUser(vo);	
	}

}
