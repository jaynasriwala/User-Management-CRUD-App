<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Footer</title>
    <style>
        *{
            margin: 0;
            padding: 0;
            box-sizing: border-box;
        }
        .footer {
            background-color: #333;
            color: #fff;
            padding: 25px;
            text-align: center;
            font-family: 'Times New Roman', Times, serif;
            font-size: 1.2rem;
            display: flex;
            justify-content: space-between;
            align-items: center;
        }
        .footer p {
        	
            margin: auto;
        }
        
        .name{
        	font-family:cursive;
        	font-weight: bold;
        	font-size: 1.2rem;
        	font-style:oblique;
        	color: orange;
        }
        .orcl{
        	color:red;
        	font-size: 1.3rem;
        	
        }
    </style>
</head>
<body>
    <div class="footer">
        <p>By - <span class ="orcl"> ORACLE </span> Certified Associate Java Programmer <span class="name">- Nasriwala Jay</span></p>
       
    </div>
</body>
</html>
