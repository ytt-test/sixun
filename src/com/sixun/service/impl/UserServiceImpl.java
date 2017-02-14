package com.sixun.service.impl;

import com.sixun.dao.IUserDao;
import com.sixun.dao.impl.UserDaoImpl;
import com.sixun.entity.User;
import com.sixun.page.PageBean;
import com.sixun.service.IUserService;

public class UserServiceImpl implements IUserService{

	IUserDao dao =new UserDaoImpl();
	public boolean addUser(User user) {
		if(user==null) return false;
		return dao.add(user);
	}

	public boolean updateUser(User t) {
		return false;
	}

	public boolean deleteUser(int id) {
		return false;
	}

	public void getAllUser(PageBean<User> pb) {
		
	}

	public User getUserById(int id) {
		return null;
	}

	public void getUserByName(PageBean<User> pb, String like) {
			
	}

}
