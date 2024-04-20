<%@page import="java.util.ArrayList"%>
<%@page import="com.royal.bean.UserBean"%>


<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>


<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>User Management System</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
        }
        .add-user-link {
          
            text-align: center;
            margin: 20px;
            padding:10px;
            background-color: blue;
            border-radius: 20px;
        }
        .user-table {
            width: 80%;
            margin: 10px auto;
            border-collapse: collapse;
        }
        .user-table th, .user-table td {
        	font-size:1rem;
            padding: 8px;
            border: 1px solid #ddd;
            text-align: center;
        }
        .user-table th {
            background-color: #f2f2ff;
        }
        .footer {
            background-color: #333;
            color: #fff;
            padding: 10px;
            text-align: center;
            position: fixed;
            bottom: 0;
            width: 100%;
        }
        .add-user-link {
          padding:10px;
          background-color:rgb(55, 55, 212);
          border-radius: 10px;
          width: 100px;
          text-align: center;
          margin: auto;
          font-size: 1rem;
          margin: 15px;
      }
      a{
        text-decoration: none;
        color: #fff;
      }
      tr{
      text-align: center;
      }
      .delete{
      background-color: rgb(231, 41, 41); 
      }
      .edit{
      background-color: rgb(255, 199, 0);
     
      }
      .edit-color{
      color:black;
      }
    </style>
</head>
<body>
    <%@ include file="head.jsp" %>
    
    <div class="add-user-link">    
        <a href="insertUser.jsp" class="">Add User</a>
    </div>
    <hr>
    <table class="user-table">
        <thead>
            <tr>
                <th>Name</th>
                <th>Email</th>
                <th>Age</th>
               
                <th colspan="2">Action</th>
            </tr>
        </thead>
        
        <%
		ArrayList<UserBean> list = (ArrayList<UserBean>) request.getAttribute("list");

			if (list != null)
			{
    					for (int i = 0; i < list.size(); i++) 
    					{
        						UserBean u = list.get(i);
		%>
		<tbody>
    <!-- Sample user data, replace with actual data from your database -->
    <tr>
        <td><%= u.getName() %></td>
        <td><%= u.getEmail() %></td>
        <td><%= u.getAge() %></td>
        <td>
        <div class="add-user-link edit">
        <a href="EditUserServlet?id=<%=u.getId()%>" class="edit-color">Edit</a>
        </div>
        </td>
        <td>
        <div class="add-user-link delete">
        <a href="DeleteUserServlet?id=<%=u.getId()%>">Delete</a>
        </div>
        </td>
    </tr>
</tbody>
<%
    }
}
%>

    </table>
    <%@ include file="footer.jsp" %>
</body>
</html>
