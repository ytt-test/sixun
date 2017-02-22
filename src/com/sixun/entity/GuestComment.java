package com.sixun.entity;

import java.util.Date;

/**
 * -- �ο����Ա�
-- ��ҵָ��������Ϣ��
CREATE TABLE guestComments(
id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
userName VARCHAR(30) NOT NULL,         -- �û�����
msgDate DATETIME ,                   -- ����ʱ��
message VARCHAR(200)            -- ����
)
 * ��ҵָ�� ������Ϣʵ����
 */

public class GuestComment {
	
	private int id;
	private String userName;
	private Date  msgDate;
	private String message;
	
	public GuestComment() {
		super();
	}

	public GuestComment(String userName, Date msgDate, String message) {
		super();
		this.userName = userName;
		this.msgDate = msgDate;
		this.message = message;
	}

	public GuestComment(int id, String userName, Date msgDate, String message) {
		super();
		this.id = id;
		this.userName = userName;
		this.msgDate = msgDate;
		this.message = message;
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

	public Date getMsgDate() {
		return msgDate;
	}

	public void setMsgDate(Date msgDate) {
		this.msgDate = msgDate;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String toString() {
		return "GuestComments [id=" + id + ", userName=" + userName
				+ ", msgDate=" + msgDate + ", message=" + message + "]";
	}
	
	
	
}
