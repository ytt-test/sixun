package com.sixun.factory;

import java.util.ResourceBundle;

/**
 * @author tk
 * ���÷�����ƶ�ȡ�����ļ� 
 */
public class BeanFactory {
	
	private static ResourceBundle bundle;
	
	static{
		
		bundle = ResourceBundle.getBundle("instance");
	}
	
	public static <T> T getInstance(String objName){
		String className = bundle.getString(objName);
		try {
			return (T) Class.forName(className).newInstance();
		} catch (Exception e) {
			throw new RuntimeException("���������쳣");
		} 
	} 
}
