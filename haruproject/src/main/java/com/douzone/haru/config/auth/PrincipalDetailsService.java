package com.douzone.haru.config.auth;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.douzone.haru.repository.UserRepository;
import com.douzone.haru.vo.UserVo;
/* 사용자 명세 서비스 */
// Authentication 객체 만들기

@Service
public class PrincipalDetailsService implements UserDetailsService{
	
	@Autowired 
	private UserRepository userRepository;
	
	// select 에 성공하면 Authentication(내부 UserDetails)dp 들어가고 
	// 르기고 시큐리티 sesstion에 session(내부Authentication(내부 UserDetails)) 요렇게 쏙들어간다
	// 앞에서 각 객체 타입으로 값들을 넣어주었기에 가능하다
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// username 이 유저 내임은 로그인 할때 <input> 트그안에 내가 정한 밸류값과 동일해야 여기 loadUserByUsername 함수에
		// 파라미터로 전달할수 있다
		UserVo userEntity = userRepository.findByUsername(username);
		if(username != null) {
			return new PrincipalDetails(userEntity);
		}
		return (UserDetails)userEntity;
	}
	
	 
	
}
