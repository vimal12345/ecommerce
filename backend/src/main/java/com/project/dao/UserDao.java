package com.project.dao;

import com.project.model.User;

public interface UserDao {
	public boolean addUser(User user);

	public User getUser(int userId);

	public User getUserByUsername(String username);
	
}
