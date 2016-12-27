package com.nongming.sunshine.dao;

import com.nongming.sunshine.entity.User;

public interface UserDao {
	
	public int addUser(User entity);
	
	public User verifyUser(String email);
}
