package com.royal.controller;

import java.io.IOException;
import java.util.ArrayList;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
/**
 * Servlet implementation class ListUserServlet
 */
public class ListUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		UserDao dao = new UserDao();
		
		ArrayList<UserBean> list = dao.getAllRecords();
		
		request.setAttribute("list",list);
		
		request.getRequestDispatcher("home.jsp").forward(request, response);
			
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
