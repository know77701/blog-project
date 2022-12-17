package com.cos.blog.test;

import java.util.List;
import java.util.Optional;
import java.util.function.Supplier;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.cos.blog.model.RoleType;
import com.cos.blog.model.User;
import com.cos.blog.repository.UserRepository;

@RestController
public class DummyControllerTest {

	@Autowired
	private UserRepository userRepository;
	
	@PostMapping("/dummy/join")
	public String join(User user) {
		user.setRole(RoleType.USER);
		userRepository.save(user);
		System.out.println(user);
		return "회원가입 완료";
	}
	
	@GetMapping("/dummy/user/{id}")
	public User userView(@PathVariable int id) {
		User user = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 유저 미존재");
		});
		return user;
	}
	
	@GetMapping("/dummy/user")
	public List<User> userList(){
		return userRepository.findAll();
	}
	
	
	@GetMapping("/dummy/user/page")
	public List<User> pageList(@PageableDefault(size = 2,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
		List<User> users = userRepository.findAll(pageable).getContent();
		return users;
	}
	
	@Transactional
	@PutMapping("/dummy/user/{id}")
	public String updateUser(@PathVariable int id, @RequestBody User requestUser) {
		User users = userRepository.findById(id).orElseThrow(()->{
			return new IllegalArgumentException("해당 유저 미존재");
		});
		users.setPassword(requestUser.getPassword());
		users.setEmail(requestUser.getEmail());
		
		return "회원 수정 완료";
	}
	
	@DeleteMapping("/dummy/user/{id}")
	public String deleteUser(@PathVariable int id) {
		try {
			userRepository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			return "삭제에 실패하였습니다.";
		}
		return "탈퇴가 완료되었습니다.";
	}
}
