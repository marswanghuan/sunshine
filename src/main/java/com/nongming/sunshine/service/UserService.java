package com.nongming.sunshine.service;

import org.springframework.stereotype.Service;

import com.nongming.sunshine.dao.UserDao;
import com.nongming.sunshine.entity.User;

@Service
public class UserService {
	private UserDao userdao;
	
	public int addUser(User entity){
		return userdao.addUser(entity);
	}
	
	public User verifyUser(String email){
		return userdao.verifyUser(email);
	}
}
