package com.sixun.entity;

/**
 * @author tk
 *--  ��ҵ֧�ֹ�Ӧ�����
CREATE TABLE supplyDemands(
id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
userName VARCHAR(30) NOT NULL,         -- �û�����
phone INT,		           -- ��ϵ�绰
eMail VARCHAR(30),		   -- ����
supplyDemand VARCHAR(30),          -- ��Ӧ&����
description VARCHAR(200)           -- ��Ӧ&��������
)
 */
public class SupplyDemand {

	
	private int id;
	private String userName;
	private int phone;
	private String eMail;
	private String supplyDemand;
	private String description;
	
	public SupplyDemand() {
		super();
	}
	
	public SupplyDemand(String userName, int phone, String eMail,
			String supplyDemand, String description) {
		super();
		this.userName = userName;
		this.phone = phone;
		this.eMail = eMail;
		this.supplyDemand = supplyDemand;
		this.description = description;
	}
	
	public SupplyDemand(int id, String userName, int phone, String eMail,
			String supplyDemand, String description) {
		super();
		this.id = id;
		this.userName = userName;
		this.phone = phone;
		this.eMail = eMail;
		this.supplyDemand = supplyDemand;
		this.description = description;
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
	public int getPhone() {
		return phone;
	}
	public void setPhone(int phone) {
		this.phone = phone;
	}
	public String geteMail() {
		return eMail;
	}
	public void seteMail(String eMail) {
		this.eMail = eMail;
	}
	public String getSupplyDemand() {
		return supplyDemand;
	}
	public void setSupplyDemand(String supplyDemand) {
		this.supplyDemand = supplyDemand;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public String toString() {
		return "SupplyDemand [id=" + id + ", userName=" + userName + ", phone="
				+ phone + ", eMail=" + eMail + ", supplyDemand=" + supplyDemand
				+ ", description=" + description + "]";
	}
	
}
