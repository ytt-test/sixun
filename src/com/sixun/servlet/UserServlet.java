package com.sixun.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixun.entity.User;
import com.sixun.service.IUserService;
import com.sixun.service.impl.UserServiceImpl;
import com.sixun.util.StringUtils;

public class UserServlet extends HttpServlet {

  IUserService service =new UserServiceImpl();
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 处理中文乱码问题	
		request.setCharacterEncoding("UTF-8");
		
		// 获取表单提交过来的url携带的参数
		String method = request.getParameter("method");
		
		System.out.println(method);
		
		if ("add".equals(method)) {
			// 添加员工
			try {
				add(request, response);
			} catch (Exception e) {
					
			}
			
		}
	}
		
	private void add(HttpServletRequest request, HttpServletResponse response)
			throws IOException {
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("passwordAgain");
		String phoneStr = request.getParameter("phone");
		String email = request.getParameter("email");
		// 所有字符串非空判断
		boolean isok = StringUtils.checkNull(userName, password, passwordAgain, phoneStr,
				email);
		if (!isok) {
			// 跳转到添加页面重新添加
			return ;
		}
		System.out.println(userName+" "+password+" "+passwordAgain+" "+phoneStr+" "+email);
		// 转型 
		try {
			service.addUser(new User(userName, password, passwordAgain, Integer.parseInt(phoneStr), email));
			// 跳转到显示所以员工页面
		} catch (Exception e) {
			throw new RuntimeException();
			// 跳转到错误页面
		}
	}
	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

				doGet(request, response);
				
	}

}
