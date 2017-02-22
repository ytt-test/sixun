package com.sixun.service;

import com.sixun.dao.IGuestCommentDao;
import com.sixun.dao.ISupplyDemandDao;
import com.sixun.dao.IUserRecordDao;
import com.sixun.dao.IUserRegisterDao;
import com.sixun.factory.BeanFactory;

/**
 * @author tk
 *  ʹ�ù���ģʽʵ����dao�����
 */
public interface BaseService {
	
	IGuestCommentDao guestCommentDao = BeanFactory.getInstance("guestCommentDao");
	ISupplyDemandDao  supplyDemandDao=BeanFactory.getInstance("supplyDemandDao");
	IUserRecordDao userRecordDao= BeanFactory.getInstance("userRecordDao");
	IUserRegisterDao userRegisterDao =BeanFactory.getInstance("userRegisterDao");
	                            
}
