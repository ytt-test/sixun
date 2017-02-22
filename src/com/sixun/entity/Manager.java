package com.sixun.entity;

/**
 * @author tk
 *����Ա��
 */
public class Manager {

	private String userName;
	private String userPwd;
	
	public Manager() {
		super();
	}
	
	public Manager(String userName, String userPwd) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	@Override
	public String toString() {
		return "Manager [userName=" + userName + ", userPwd=" + userPwd + "]";
	}
	
}
