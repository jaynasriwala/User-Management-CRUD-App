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
 * Servlet implementation class UpdateUserServlet
 */
public class UpdateUserServlet extends HttpServlet {
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String age =  request.getParameter("age");
		
		Boolean flag = false;
		
		UserBean ubean = new UserBean();
		
		request.setAttribute("id", id);
		if(name != null && name.trim().length()>0) {
			
			ubean.setName(name);
			request.setAttribute("name", name);
		}
		else {
			request.setAttribute("padName", "style=\"padding-top:1rem;\"");
			flag=true;
			request.setAttribute("errName", "<span style=\"color:red;margin-bottom:1rem;font-size:0.6rem;\">*Please Enter Valid Name.</span>");
		}
		
		if(email != null && email.trim().length()>0) {
			
			ubean.setEmail(email);
			request.setAttribute("email", email);
		}
		else {
			flag=true;
			request.setAttribute("padStd", "style=\"padding-top:1rem;\"");
			request.setAttribute("errStd", "<font color='red' style=\"color:red;margin:1rem;font-size:0.6rem;\">*Please Enter Valid Email.</font>");
		}

		if(age != null && age.trim().length()>0) {
			
			ubean.setAge(Integer.parseInt(age));
			request.setAttribute("marks", Integer.parseInt(age));
		}
		else {
			flag=true;
			request.setAttribute("padMarks", "style=\"padding-top:1rem;\"");
			request.setAttribute("errMarks", "<font color='red' style=\"color:red;margin:1rem;font-size:0.6rem;\"}>*Please Enter Valid Age.</font>");
		}
		
		RequestDispatcher rd = null;
		
		if(flag) {
			rd = request.getRequestDispatcher("editUser.jsp");
		}
		else {
			
			UserDao dao = new UserDao();
			
			int rowsAffected = dao.UpdateUser(ubean,id);
			
			if(rowsAffected >0) {
				rd = request.getRequestDispatcher("ListUserServlet");
			}else {
				rd = request.getRequestDispatcher("EditUserServlet");
			}

		}
		rd.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		doGet(request, response);
	}

}
