package com.cos.blog.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@Service 
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@Transactional
	public void joinUser(User user) {
		String password = user.getPassword();
		String encPassword = encoder.encode(password);
		user.setPassword(encPassword);
		user.setRole(RoleType.USER);
		userRepository.save(user);
	}

	@Transactional
	public void updateUser(User requestUser) {
		User user = userRepository.findById(requestUser.getId())
				.orElseThrow(() ->{
					return new IllegalArgumentException("회원찾기 실패");
				});
		System.out.println(requestUser);
		String password = requestUser.getPassword();
		String encPassword = encoder.encode(password);
		
		user.setPassword(encPassword);
		user.setEmail(requestUser.getEmail());
	}
	
}
