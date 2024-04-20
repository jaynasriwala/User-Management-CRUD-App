<%@page import="com.royal.bean.UserBean"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Edit user Details</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            background-color: #f4f4f2;
        }
        .container {
            max-width: 400px;
            margin: 50px auto;
            padding: 20px;
            background-color: #fff;
            border-radius: 20px;
            box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }
        h2 {
            text-align: center;
            color: rgb(55, 55, 212);
            font-size: 2rem;
            font-family: 'Times New Roman', Times, serif;
            margin-bottom: 20px;
        }
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: inline-block;
            width: 100px;
            margin-bottom: 5px;
        }
        .form-group input[type="text"] {
            width: calc(100% - 110px);
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        .btn-container {
            text-align: center;
        }
        .btn {
            width: 30%;
            padding: 10px;
            background-color: rgb(55, 55, 212);
            color: #fff;
            border: none;
            border-radius: 5px;
            cursor: pointer;
            font-size: 1rem;
        }
        .btn:hover {
            background-color: #0556b3;
        }
    </style>
</head>

<body>

<%@ include file="head.jsp" %>

<div class="container">
    <h2>Edit User</h2>
    <form action="UpdateUserServlet" class="rounded bg-light p-4">
        <div class="form-group">
            <label for="id">Id:</label>
            <input type="text" name="id" value='${id}' class="form-control" readonly />
        </div>
        <div class="form-group">
            <label for="name">Name:</label>
            ${errName}<input type="text" name="name" class="form-control" value='${name}' />
        </div>
        <div class="form-group">
            <label for="email">Email:</label>
            ${errStd}<input type="text" name="email" class="form-control" value='${email}' />
        </div>
        <div class="form-group">
            <label for="Age">Age:</label>
            ${errMarks}<input type="text" name="age" class="form-control" value='${age}' />
        </div>
        <div class="btn-container">
            <input type="submit" class="btn" value="Edit"/>
        </div>
    </form>
</div>

<%@ include file="footer.jsp" %>
</body>
</html>
