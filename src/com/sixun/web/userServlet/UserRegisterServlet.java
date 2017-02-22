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
 **         Servlet: ���ղ��� ��ת ��ʾ-----jsp ҵ���߼��ж�---service
 * 
 */
public class UserRegisterServlet extends UserBaseServlet {
	
	String path;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		path= this.getServletContext().getContextPath();
		
		// ����������������
		request.setCharacterEncoding("UTF-8");
		// ��ȡ���ύ������urlЯ���Ĳ���
		String method = request.getParameter("method");
			
		if ("register".equals(method)) {
			// �û�ע����Ϣ���
			try {
				register(request, response);
			} catch (Exception e) {

			}
			// �ض���
		} else if ("update".equals(method)) {
				
			
		} else if ("findById".equals(method)) {
			// ����Id��ѯ
				
		}

	}
	

	private void register(HttpServletRequest request,
			HttpServletResponse response) throws IOException {
		// �õ�ҳ���ύ������
		String userName = request.getParameter("userName");
		String userPwd = request.getParameter("userPwd");
		String userPwdAgain = request.getParameter("userPwdAgain");
		String phone = request.getParameter("phone");
		String eMail = request.getParameter("eMail");
		// �����ַ����ǿ��ж�
		boolean isok = StringUtils.checkNull(userName, userPwd, userPwdAgain,
				phone, eMail);
		if (isok) {
			// ��ת�����ҳ���������
			return;
		}
		/*IUserRegisterService service = new UserRegisterServiceImpl();
		UserRegister register = (UserRegister) service.getByName(userName);
		if (userName.equals(register.getUserName())) {
			*/
		
		// �������-->���ݿ�
		try {
			userRegisterService.add(new UserRegister(userName, userPwd, userPwdAgain, Long.parseLong(phone),
					eMail));
			//response.sendRedirect(request.getContextPath()+"/App/denglu/zhuceshibai.jsp");
			response.sendRedirect(request.getContextPath()+"/App/denglu/login.jsp");
		} catch (Exception e) {
			// throw new RuntimeException();
			// ��ת������ҳ��
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
