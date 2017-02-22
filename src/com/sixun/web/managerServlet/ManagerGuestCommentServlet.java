package com.sixun.web.managerServlet;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.ConvertUtils;
import org.apache.commons.beanutils.locale.converters.DateLocaleConverter;

import com.sixun.entity.GuestComment;
import com.sixun.page.PageBean;

public class ManagerGuestCommentServlet extends ManagerBaseServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// ����������������
		request.setCharacterEncoding("UTF-8");
		
		// ��ȡ���ύ������urlЯ���Ĳ���
		String method = request.getParameter("method");
		System.out.println(method);
			
		if ("add".equals(method)) {
			GuestComment messages =copyToBean(request, GuestComment.class);
			System.out.println("�����Ϣ�ɹ���" + messages);
			// �ض���
			if (!guestCommentService.add(messages)) {
				throw new RuntimeException("�����Ϣʧ��");
			}
			response.sendRedirect("/App/zuozong.jsp");
		} else if ("list".equals(method)) {
			
			getMessages();
			getByPage(request);
			request.getRequestDispatcher("/sys/message/messageList.jsp").forward(request, response);
		}
	}
	
	public void getMessages() {
		// ��ѯ��ϵ��Ϣ-----��Ҫ���浽context������У���Ϊ�õĵط��Ƚ϶࣬���Ҳ�ϵ��Ϣ�Ƚ���
		
		// �ȴ�������л�ȡ
		List<GuestComment> messages = (List<GuestComment>) this.getServletContext()
				.getAttribute("messages");
		if (messages == null) {
			// �����ȡ������ȥ��ѯ
			messages = guestCommentService.getByName(null);
			this.getServletContext().setAttribute("Messages", messages);
		}
	}
	
	public void getByPage(HttpServletRequest request) {
			
		// ʹ�÷�ҳpageNow ʹ������ message
		String pageNow = request.getParameter("pageNow");
		String pageCount = request.getParameter("pageCount");
		String message = request.getParameter("message");
		// �ж�realName �� userName �Ƿ���Ҫ���浽session "name" ""
		HttpSession session = request.getSession();
		
		if (pageNow == null) {
			pageNow = (String) session.getAttribute("pageNow");
			System.out.println("pageNow" + pageNow);
		}

		if (pageCount == null) {
			pageCount = (String) session.getAttribute("pageCount");
			System.out.println("pageCount" + pageCount);
		}
			
		if (message == null) {

			message = (String) session.getAttribute("message");
			System.out.println("message" + message);
		} else {
			session.setAttribute("message", message);
		}

		PageBean<GuestComment> pb = guestCommentService.list(pageNow, message);
		
		System.out.println(pb + " ---------------------");
	
		request.setAttribute("pb", pb);
		System.out.println("----------------��ҳ���--------------------");
		System.out.println(pb.getPageNow() + "  " + pb.getTotalRows());
		System.out.println(pb.getDatas());

	}

	/**
	 * ��װ �ϴ���Ϣ Ŀ��----------�õ�һ��Messages����
	 * 
	 * @param request
	 */
	private <T> T copyToBean(HttpServletRequest request, Class<T> clazz) {
		//ע�����ڽ�����ʽ
		ConvertUtils.register(new DateLocaleConverter(), Date.class);
		T t = null;
		try {
			t= clazz.newInstance();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		try {
			 Map map   = request.getParameterMap();
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
