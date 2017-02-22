package com.sixun.web.managerServlet;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;

import com.sixun.entity.UserRecord;
import com.sixun.entity.UserRegister;
import com.sixun.page.PageBean;
import com.sixun.service.impl.UserRegisterServiceImpl;
import com.sixun.util.StringUtils;

/**
 * @author tk
 * 
 **         Servlet: ���ղ��� ��ת ��ʾ-----jsp ҵ���߼��ж�---service
 * 
 */
public class ManagerUserRegisterServlet extends ManagerBaseServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		to=this.getServletContext().getContextPath()+"/servlet/managerUserRegister?method=list";
		// ����������������
		request.setCharacterEncoding("UTF-8");
		// ��ȡ���ύ������urlЯ���Ĳ���
		String method = request.getParameter("method");
			
		if ("register".equals(method)) {
			// �û�ע����Ϣ���
			UserRegister userRegister = copyToBean(request, UserRegister.class);
			
			System.out.println("ע��ɹ�"+userRegister);
			// �ض���
			if (!userRegisterService.add(userRegister)) {
				throw new RuntimeException("�����Ϣʧ��");
			}
			request.setAttribute("userRegister", userRegister);
			request.getRequestDispatcher("/App/denglu/login.jsp").forward(request, response);
		} else if ("update".equals(method)) {
				
			UserRegister userRegister =copyToBean(request, UserRegister.class);
			System.out.println("�޸�userRecord��" + userRegister);
			if (!userRegisterService.update(userRegister)) {
					
				throw new RuntimeException("�޸���Ϣʧ��");
			}
			
		} else if ("delete".equals(method)) {
			// ɾ��
			String id = request.getParameter("id");
			userRegisterService.delete(id);
			
		} else if ("list".equals(method)) {
			// ��ѯ������
			getUser();
			getByPage(request);
			to = request.getRequestDispatcher("/sys/userRegister/registerList.jsp");
				
		} else if ("findById".equals(method)) {
			// ����Id��ѯ
			findById(request, response);
				
			to = request.getRequestDispatcher("/sys/userRegister/updateRegister.jsp");	
		}

	}
	
	public void getUser() {
		// ��ѯע����Ϣ-----��Ҫ���浽context������У���Ϊ�õĵط��Ƚ϶࣬�����û���Ϣ�Ƚ���
		// �ȴ�������л�ȡ
		List<UserRegister> user = (List<UserRegister>) this.getServletContext().getAttribute(
				"user");
		if (user == null) {
			// �����ȡ������ȥ��ѯ
			user = userRegisterService.getByName(null);
			this.getServletContext().setAttribute("user", user);
		}
	}

	public void getByPage(HttpServletRequest request) {
		// ʹ�÷�ҳpageNow ʹ������userName pageCount
		String pageNow = request.getParameter("pageNow");
		String userName = request.getParameter("userName");
		String pageCount = request.getParameter("pageCount");
		// �ж�userName �� pageCount �Ƿ���Ҫ���浽session " " ""
		HttpSession session = request.getSession();
		
		if (userName == null) {
			userName = (String) session.getAttribute("userName");
			// System.out.println(userName);
		} else {
			// System.out.println(userName);
			session.setAttribute("userName", userName);
		}

		if (pageNow == null) {
			pageNow = (String) session.getAttribute("pageNow");
		} else {

			session.setAttribute("pageNow", pageNow);
		}

		if (pageCount == null) {
			pageCount = (String) session.getAttribute("pageCount");
		} else {
			session.setAttribute("pageCount", pageCount);
		}

		PageBean<UserRegister> pb = userRegisterService.list(pageNow, userName);

		request.setAttribute("pb", pb);

		System.out.println("----------------��ҳ���--------------------");
		System.out.println(pb.getPageNow() + "  " + pb.getTotalRows());
		System.out.println(pb.getDatas());

	}

	private void findById(HttpServletRequest request,
			HttpServletResponse response) {
		String id = request.getParameter("id");
		UserRegister user = new UserRegisterServiceImpl().getById(id);
		request.setAttribute("user", user);
	}
	
	private void update(HttpServletRequest request, HttpServletResponse response) {
		String id = request.getParameter("id");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String passwordAgain = request.getParameter("password");
		String phone = request.getParameter("phone");
		String email = request.getParameter("email");
		// �����ַ����ǿ��ж�
		boolean isok = StringUtils.checkNull(id, username, password,
				passwordAgain, phone, email);
		if (isok) {
			// ��ת���޸�ҳ���������
			return;
		}

		System.out.println(id + " " + username + " " + password + " "
				+ passwordAgain + " " + phone + " " + email);
		// ת��
		try {

			// ��ת���޸ú��ҳ��
			response.sendRedirect("/sys/register/registerList.jsp");

		} catch (Exception e) {
			// throw new RuntimeException();
			// ��ת������ҳ��
			e.printStackTrace();
		}
	}

	/**
	 * ��װ �ϴ���Ϣ Ŀ��----------�õ�һ��Messages����
	 * 
	 * @param request
	 */
	private <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		T t = null;
		try {
			t = clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}

		try {
			Map map = request.getParameterMap();
			BeanUtils.populate(t, map);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return t;
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);

	}

}
