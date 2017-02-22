package com.sixun.web.filter;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

public class EncodingFilter implements Filter{

	String[] dirtys;
	public void init(FilterConfig filterConfig) throws ServletException {
		dirtys = filterConfig.getInitParameter("dirty").split("-");
	}

	HttpServletRequest req;
	public void doFilter(ServletRequest request, ServletResponse response,
			FilterChain chain) throws IOException, ServletException {
		req =(HttpServletRequest) request;
		System.out.println("-----����post��������---------");
	req.setCharacterEncoding("UTF-8");

	System.out.println("--------����get��������----");
	/*
	 *����һ��request ����Ĵ������
	 *�������鿴get�ύ�Ĳ���
	 *��getParameter �����ķ���ֵ���д������� 
	 * 
	 **/
HttpServletRequest proxy=	(HttpServletRequest) Proxy.newProxyInstance(req.getClass().getClassLoader(),
			new Class[]{HttpServletRequest.class},
			new InvocationHandler() {
				
				public Object invoke(Object proxy, Method method, Object[] args)
						throws Throwable {
					if("getParameter".equals(method.getName())){
						String value= req.getParameter(args[0].toString());
						if("get".equalsIgnoreCase(req.getMethod())){
							if(value!=null){
								value= new String(value.getBytes("ISO8859-1"), "UTF-8");
							}
						}
					if(value!=null){
						//������Ч����   ��г
						for(String d:dirtys){//NND-TMD-SB-GCD
						value =	value.replaceAll(d, "***");
						}
					}
					return value;
					}
					
					return method.invoke(req, args);
				}
			});
	
	//chain.doFilter(�������,response);
	chain.doFilter(proxy, response);
	}

	public void destroy() {
		
	}

}
