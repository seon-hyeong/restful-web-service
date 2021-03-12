package com.example.demo.user;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class UserDaoService {
	private static List<User> users = new ArrayList<>(); //User 값 저장 하는 공간 생성
	
	private static int userCount=3;
	
	static {
		users.add(new User(1,"seon hyeong", new Date()));
		users.add(new User(2,"seon hyeong1", new Date()));
		users.add(new User(3,"seon hyeong2", new Date()));
	}
	
	public List<User> findAll(){
		return users;
	}
	
	public User save(User user) {
		if (user.getId() == null) {
			user.setId(++userCount);
		}
		
		users.add(user);
		return user;
	}
	
	public User findOne(int id) {
		for (User user : users) {
			if (user.getId() == id) {
				return user;
			}
		}
		return null;
	}
}