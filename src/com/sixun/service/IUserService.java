package com.sixun.service;

import com.sixun.entity.User;
import com.sixun.page.PageBean;

public interface IUserService extends BaseService {

	public boolean addUser(User t);
	public boolean updateUser(User t);
	public boolean deleteUser(int id);
	public void  getAllUser(PageBean<User> pb);
	public User getUserById(int id);
	
}
