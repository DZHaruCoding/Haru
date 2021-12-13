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
	
	public UserVo findByUsername(String userid) {
		return userRepository.findByUsername(userid);
	}

	public UserVo findUserBykey(String key) {
		return userRepository.findUserBykey(key);
	}
	
	// 유저 인증권한 T로 변경하는 서비스
	public void updateUserAuth(UserVo authUser) {
		userRepository.updateUserAuth(authUser);
	}

	public UserVo findEmailById(String userEmail) {
		return userRepository.findEmailById(userEmail);
	}
}
