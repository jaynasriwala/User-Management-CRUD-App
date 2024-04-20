<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Insert User</title>
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
        .form-group {
            margin-bottom: 20px;
        }
        .form-group label {
            display: block;
            margin-bottom: 5px;
        }
        h2{
        text-align: center;
        color: rgb(55, 55, 212);
       font-size:2rem;
       font-family: 'Times New Roman', Times, serif;
        }
        .form-group input[type="text"], .form-group input[type="email"], .form-group input[type="number"] {
            width: 100%;
            padding: 10px;
            border: 1px solid #ccc;
            border-radius: 3px;
            box-sizing: border-box;
        }
        .form-group input[type="submit"] {
        	
            width: 30%;
            margin :auto;
            padding: 10px;
            background-color: rgb(55, 55, 212);
            color: #fff;
            border: none;
            border-radius: 5px;
            align-content:center;
            cursor: pointer;
            font-size: 1rem;
        }
        .form-group input[type="submit"]:hover {
            background-color: #0556b3;
        }
        
    </style>
</head>
<body>

<%@ include file="head.jsp" %>
    <div class="container">
        <h2>Add User</h2>
        <form action="insertUserServlate" method="post">
            <div class="form-group">
                <label for="name">Name:</label>
                <input type="text" id="name" name="name" required>
            </div>
            <div class="form-group">
                <label for="email">Email:</label>
                <input type="email" id="email" name="email" required>
            </div>
            <div class="form-group">
                <label for="age">Age:</label>
                <input type="number" id="age" name="age" required>
            </div>
            <div class="form-group">
                <input type="submit" value="Submit">
            </div>
        </form>
    </div>
<%@ include file="footer.jsp" %>
</body>
</html>
