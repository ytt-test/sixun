package com.sixun.entity;

import java.io.Serializable;


/**
 * -- �û�ע����Ϣ��
CREATE TABLE userRegisters(
id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
userName VARCHAR(30) NOT NULL,  -- �û���
userPwd VARCHAR(20),		-- ����
userPwdAgain VARCHAR(20),       -- �ٴ�ȷ������
phone INT,			-- ��ϵ�绰
eMail VARCHAR(30)		-- ����
)
 */
public class UserRegister implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	//�û�id
	private int id;
	// �û���
	private String userName;
	// ����
	private String userPwd;
	// �ٴ�ȷ������
	private String userPwdAgain;
	// ��ϵ�绰
	private long phone;
	// ����
	private String eMail;

	public UserRegister() {
		super();
	}

	public UserRegister(String userName, String userPwd, String userPwdAgain,
			long phone, String eMail) {
		super();
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPwdAgain = userPwdAgain;
		this.phone = phone;
		this.eMail = eMail;
	}

	public UserRegister(int id, String userName, String userPwd,
			String userPwdAgain, long phone, String eMail) {
		super();
		this.id = id;
		this.userName = userName;
		this.userPwd = userPwd;
		this.userPwdAgain = userPwdAgain;
		this.phone = phone;
		this.eMail = eMail;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public String getUserPwdAgain() {
		return userPwdAgain;
	}

	public void setUserPwdAgain(String userPwdAgain) {
		this.userPwdAgain = userPwdAgain;
	}

	public long getPhone() {
		return phone;
	}

	public void setPhone(long phone) {
		this.phone = phone;
	}

	public String geteMail() {
		return eMail;
	}

	public void seteMail(String eMail) {
		this.eMail = eMail;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", userName=" + userName + ", userPwd="
				+ userPwd + ", userPwdAgain=" + userPwdAgain + ", phone="
				+ phone + ", eMail=" + eMail + "]";
	}

	
	
}
