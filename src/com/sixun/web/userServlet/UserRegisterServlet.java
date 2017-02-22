package com.sixun.web.userServlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixun.entity.UserRegister;

import com.sixun.service.IUserRegisterService;
import com.sixun.service.impl.UserRegisterServiceImpl;
import com.sixun.util.StringUtils;

/**
 * @author tk
 * 
 **         Servlet: 接收参数 跳转 显示-----jsp 业务逻辑判断---service
 * 
 */
public class UserRegisterServlet extends UserBaseServlet {
	
	String path;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		path= this.getServletContext().getContextPath();
		
		// 处理中文乱码问题
		request.setCharacterEncoding("UTF-8");
		// 获取表单提交过来的url携带的参数
		String method = request.getParameter("method");
			
		if ("register".equals(method)) {
			// 用户注册信息添加
			try {
				register(request, response);
			} catch (Exception e) {

			}
			// 重定向
		} else if ("update".equals(method)) {
				
			
		} else if ("findById".equals(method)) {
			// 根据Id查询
				
		}

	}
	

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// 得到页面提交的数据
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userPwdAgain = request.getParameter("userPwdAgain");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");
		// 所有字符串非空判断
		boolean isok = StringUtils.checkNull(userName, userPwd, userPwdAgain,
				phone, eMail);
		if (isok) {
			// 跳转到添加页面重新添加
			return;
		}
		/*IUserRegisterService service = new UserRegisterServiceImpl();
		UserRegister register = (UserRegister) service.getByName(userName);
		if (userName.equals(register.getUserName())) {
			*/
		
		// 添加数据-->数据库
		try {
			userRegisterService.add(new UserRegister(userName, userPwd, userPwdAgain, Long.parseLong(phone),
					eMail));
			//response.sendRedirect(request.getContextPath()+"/App/denglu/zhuceshibai.jsp");
			response.sendRedirect(request.getContextPath()+"/App/denglu/login.jsp");
		} catch (Exception e) {
			// throw new RuntimeException();
			// 跳转到错误页面
			e.printStackTrace();
		}		
	/*}else {
		response.sendRedirect(request.getContextPath()+"/App/denglu/zhucechenggong(1).jsp");
	}*/
	}
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
