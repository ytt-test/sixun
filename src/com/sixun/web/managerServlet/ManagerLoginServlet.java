package com.sixun.web.managerServlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.sixun.util.StringUtils;


public class ManagerLoginServlet extends ManagerBaseServlet {
	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String method = request.getParameter("method");
		
		if ("login".equals(method)) {
			try {
				login(request, response);
			} catch (Exception e) {
				throw new RuntimeException("��¼����");
			}
		}
		
	}
	
	private void login(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		System.out.println(username+" "+password);
		
		boolean isok = StringUtils.checkNull(username, password);
		
		if (!isok) {
			// ��ת�����ҳ���������
			return ;
		}
		
		
			
			
			try{
			// ��½�ɹ�---����һ������Ա����
			// ����session��
			HttpSession session = request.getSession();
			
			// ��תҳ��
			System.out.println("��½�ɹ�");
			response.sendRedirect("/SiXunProject/App/index2.jsp");
			}catch (Exception e) {
				throw new RuntimeException("��¼----------------------����");

			}
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

			doGet(request, response);
	}

}
