package com.sixun.web.userServlet;

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

public class UserGuestCommentServlet extends UserBaseServlet {

	String path;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		path = this.getServletContext().getContextPath();
		
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
			response.sendRedirect( "/App/zuozong.jsp");
		} 
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
