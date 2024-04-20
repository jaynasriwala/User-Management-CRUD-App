package com.royal.controller;

import java.io.IOException;

import com.royal.bean.UserBean;
import com.royal.dao.UserDao;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;



public class insertUserServlate extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
	
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		int age = Integer.parseInt(request.getParameter("age"));
		
		
		System.out.println("name:- "+name);
		System.out.println("email:- "+email);
		System.out.println("age:- "+age);
		
		UserBean ubean = new UserBean(0,name,email,age);
		
		UserDao dao = new UserDao();
		
		int rowsAffecte = dao.insertUser(ubean);
		
		RequestDispatcher rd=null;
		if (rowsAffecte>0) 
		{
			rd = request.getRequestDispatcher("ListUserServlet");
		} else 
		{
			rd = request.getRequestDispatcher("insertUser.jsp");
		}
		
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
