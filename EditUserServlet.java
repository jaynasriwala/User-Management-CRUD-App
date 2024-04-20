package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


/**
 * Servlet implementation class EditUserServlet
 */
public class EditUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt( request.getParameter("id"));
		UserDao dao = new UserDao();
		
		UserBean u = dao.getUserByid(id);	
		request.setAttribute("name", u.getName());
		request.setAttribute("email", u.getEmail());
		request.setAttribute("age", u.getAge());
		request.setAttribute("id", u.getId());
		
		
		request.getRequestDispatcher("edituser.jsp").forward(request, response);

	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
