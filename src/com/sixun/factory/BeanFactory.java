package com.sixun.factory;

import java.util.ResourceBundle;

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
			throw new RuntimeException("创建对象异常");
		} 
	} 
}
