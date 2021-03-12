package com.example.demo.user;

import java.net.URI;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class UserController {
	private UserDaoService service;
	
	public UserController(UserDaoService service) {
		this.service = service; //의존성 주입
	}
	
	//전체 사용자 조회
	@GetMapping(path = "/users")
	public List<User> retrieveAllUsers(){
		return service.findAll();
	}
	
	//사용자 아이디별 조회 GET /users/1 or /users/10
	@GetMapping(path = "/users/{id}")
	public User retrieveUser(@PathVariable int id) {
		User user = service.findOne(id);
		
		if (user == null) {
			throw new UserNotFoundException(String.format("ID[%s] not found", id));
		}
		return user;
	}
	 
	// 사용자 생성
	@PostMapping(path = "/users")
	public ResponseEntity<User> createUser(@RequestBody User user){
		User savedUser = service.save(user);
		
		// HTTP Status Code 제어
		// post시 똑같이 다 200 ok 하는 것 보다
		// 201 created 등 다르게 status code 나오게 하는 게 좋은 방법
		URI location = ServletUriComponentsBuilder.fromCurrentRequest()
				.path("/{id}")
				.buildAndExpand(savedUser.getId())
				.toUri();
		return ResponseEntity.created(location).build();
	}
	
	// 사용자 삭제
	@DeleteMapping(path = "/users/{id}")
	public void deleteUser(@PathVariable int id) {
		User user = service.deleteById(id);
		
		if(user == null) {
			throw new UserNotFoundException(String.format("ID[%s] not found", id));
		}
	}
	
	// 사용자 수정
	@PutMapping(path = "/users/{id}")
	public void updateUser(@RequestBody User setUser,@PathVariable int id){
		User user = service.updateById(setUser, id);
		
		if (user == null) {
			throw new UserNotFoundException(String.format("ID[%s] not found", id));
		}
	}
}
