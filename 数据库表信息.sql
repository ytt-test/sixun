/*�������ݿ�*/
CREATE DATABASE sixun CHARACTER SET utf8;
/* ʹ��sixun���ݿ�*/
USE sixun;

-- �û�ע����Ϣ��
CREATE TABLE userRegisters(
id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
userName VARCHAR(30) NOT NULL,  -- �û���
userPwd VARCHAR(20),		-- ����
userPwdAgain VARCHAR(20),       -- �ٴ�ȷ������
phone INT,			-- ��ϵ�绰
eMail VARCHAR(30)		-- ����
)

-- �û�������Ϣ¼���
CREATE TABLE userRecords(

id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
photo VARCHAR(100),		   -- ͷ��ͼƬ
userName VARCHAR(30) ,             -- �û���
realName VARCHAR(20),		   -- ��ʵ����
gender CHAR(5),                    -- �Ա�
phone INT,		           -- ��ϵ��ʽ
course VARCHAR(50),		   -- ��ѵ�γ�
school VARCHAR(50),		   -- ѧУ
profession VARCHAR(50), 	   -- רҵ
education VARCHAR(100),		   -- ѧ��
introduction VARCHAR(200)  	   -- ���ҽ���
)


--�ο����Ա�
-- ��ҵָ��������Ϣ��
CREATE TABLE guestComments(
id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
userName VARCHAR(30) NOT NULL,         -- �û�����
msgDate DATETIME ,                   -- ����ʱ��
message VARCHAR(200)            -- ����
)


--  ��ҵ֧�ֹ�Ӧ�����
CREATE TABLE supplyDemands(
id INT PRIMARY KEY AUTO_INCREMENT, -- ����id
userName VARCHAR(30) NOT NULL,         -- �û�����
phone INT,		           -- ��ϵ�绰
eMail VARCHAR(30),		   -- ����
supplyDemand VARCHAR(30),          -- ��Ӧ&����
description VARCHAR(200)           -- ��Ӧ&��������
)







