package com.royal.controller;

import java.io.IOException;


import com.royal.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		int id = Integer.parseInt(request.getParameter("id"));
		
		UserDao dao = new UserDao();
		
		int rowsAffected = dao.deleteUser(id);	
		RequestDispatcher rd=null;
		if (rowsAffected>0) {
			rd = request.getRequestDispatcher("ListUserServlet");
				
			
		} else 
		{
			rd = request.getRequestDispatcher("insertUser.jsp");
			
		}
		rd.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}

}
