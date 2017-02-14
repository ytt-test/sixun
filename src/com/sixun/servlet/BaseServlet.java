package com.sixun.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.sixun.factory.BeanFactory;
import com.sixun.service.INewsService;
import com.sixun.service.IUserService;


public class BaseServlet extends HttpServlet {

	INewsService newsService = BeanFactory.getInstance("newsService");
	IUserService userService = BeanFactory.getInstance("userService");
	Object to;
	@Override
	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
			
		super.service(request, response);
		
		 //Ìø×ª
 		if(to instanceof RequestDispatcher){
 			((RequestDispatcher)to).forward(request, response);
 		}else if(to instanceof String){
 			response.sendRedirect(to.toString());
 		}
	}

}
