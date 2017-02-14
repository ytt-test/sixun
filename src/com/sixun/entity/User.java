package com.sixun.entity;

import java.io.Serializable;

import java.util.Date;

/**
 * @author 用户实体类
 */
public class User implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//用户id
	private String id;
	// 用户名
	private String userName;
	// 密码
	private String password;
	// 再次确认密码
	private String passwordAgain;
	// 联系电话
	private int phone;
	// 邮箱
	private String email;

	public User() {
	}

	public User( String userName, String password,
			String passwordAgain, int phone, String email) {
		super();
		this.userName = userName;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.phone = phone;
		this.email = email;
	}
	
	public User(String id, String userName, String password,
			String passwordAgain, int phone, String email) {
		super();
		this.id = id;
		this.userName = userName;
		this.password = password;
		this.passwordAgain = passwordAgain;
		this.phone = phone;
		this.email = email;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordAgain() {
		return passwordAgain;
	}

	public void setPasswordAgain(String passwordAgain) {
		this.passwordAgain = passwordAgain;
	}

	public int getPhone() {
		return phone;
	}

	public void setPhone(int phone) {
		this.phone = phone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
