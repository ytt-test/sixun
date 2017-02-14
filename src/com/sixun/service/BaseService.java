package com.sixun.service;

import com.sixun.dao.INewsDao;
import com.sixun.dao.IUserDao;
import com.sixun.factory.BeanFactory;

public interface BaseService {
	
	INewsDao newDao= BeanFactory.getInstance("newDao");
	IUserDao userDao =BeanFactory.getInstance("userDao");
}
