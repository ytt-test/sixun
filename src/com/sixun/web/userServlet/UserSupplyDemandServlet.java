package com.sixun.web.userServlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class UserSupplyDemandServlet extends UserBaseServlet {

	String path;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		path= this.getServletContext().getContextPath();
			
		// ����������������
		request.setCharacterEncoding("UTF-8");
		// ��ȡ���ύ������urlЯ���Ĳ���
		String method = request.getParameter("method");
			
		if ("add".equals(method)) {
			// ��Ϣ���
			
			// �ض���
		} else if ("update".equals(method)) {
				
			
		} else if ("findById".equals(method)) {
			// ����Id��ѯ
				
		}
		
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			doGet(request, response);
	}

}
