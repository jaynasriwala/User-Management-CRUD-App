package com.royal.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import com.royal.bean.UserBean;
import com.royal.utill.DBConnection;

public class UserDao 
{

	public int insertUser(UserBean ubean) 
	{
		String insertquery = "INSERT INTO user(name,email,age) values(?,?,?)";
		Connection conn = DBConnection.getConnection();
		
		PreparedStatement pstmt = null;
		
		int rowsAffected = 0;
		
		if(conn!=null)
		{
			
			try 
			{
				pstmt = conn.prepareStatement(insertquery);
				pstmt.setString(1, ubean.getName());
				pstmt.setString(2, ubean.getEmail());
				pstmt.setInt(3, ubean.getAge());
				
				rowsAffected = pstmt.executeUpdate();
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
			
			
		}
		else 
		{
			System.out.println("user db not connected");
		}
		
		return rowsAffected;
		
	}

	public ArrayList<UserBean> getAllRecords()
	{
		String selectQuery = "SELECT * FROM user";
		
		Connection conn = DBConnection.getConnection();
		ResultSet rs = null;
		
		PreparedStatement pstmt = null;
		
		UserBean s = null;
		ArrayList<UserBean> list = new ArrayList<UserBean>();
		
		if (conn!=null) {
			try {
				pstmt = conn.prepareStatement(selectQuery);
				
				
				rs = pstmt.executeQuery();
				
				while(rs.next())
				{
					int id = rs.getInt(1);
					String name = rs.getString(2);
					String email = rs.getString(3);
					int age = rs.getInt(4);
					
					s = new UserBean (id,name,email,age);
					list.add(s);
					
				}
				
				
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("student db not connected");
		}
		
		return list;
		
	}
	
	
	public int deleteUser(int id) 
	{
		String deletequery =  "DELETE FROM user WHERE id = ?";
		Connection conn = DBConnection.getConnection();
		PreparedStatement pstmt = null;
		
		int rowsAffected = 0;
		
		if (conn!=null) {
			try {
				pstmt = conn.prepareStatement(deletequery);
				
				pstmt.setInt(1,id);
				
				rowsAffected = pstmt.executeUpdate();
			} catch (SQLException e) 
			{
				e.printStackTrace();
			}
		} else 
		{
			System.out.println("student db not connected");
		}
		
		return rowsAffected;
		
	}
	public UserBean getUserByid(int id) {
		
		Connection conn = DBConnection.getConnection();
		String selectQuery= "SELECT * FROM user WHERE id=?";		
		PreparedStatement pstmt = null;
		ResultSet rs = null ;
		
		UserBean u =null;
		
		if(conn!=null) {
			
			try {
				
				pstmt = conn.prepareStatement(selectQuery);
				
				pstmt.setInt(1, id);
				
				rs = pstmt.executeQuery();				
				
				rs.next();
				
				id = rs.getInt(1);
				String name = rs.getString(2);
				String email= rs.getString(3);
				int age = rs.getInt(4);
	
				u = new UserBean(id,name,email,age);
								    
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
		}
		else {
			System.out.println("StudentDao :: DB not connected -- "+conn);
		}
		
		
		return u;
		
	}
	
public int UpdateUser(UserBean ubean,int id) {
		
		Connection conn = DBConnection.getConnection();
		String updateQuery= "UPDATE user SET name=?,email=?,age=? WHERE id=?";		
		PreparedStatement pstmt = null;
		int rowsAffected=0;
		if(conn!=null) {
				
			try {
				
				pstmt = conn.prepareStatement(updateQuery);
				
				pstmt.setString(1, ubean.getName());
				pstmt.setString(2, ubean.getEmail());
				pstmt.setInt(3, ubean.getAge());
				pstmt.setInt(4, id);
				
				rowsAffected = pstmt.executeUpdate();				
				
				
			} catch (Exception e) {
				e.printStackTrace();
			}
				
				
		}
		else {
			System.out.println("UserDao :: DB not connected -- "+conn);
		}
			
		return rowsAffected;
	}
		
}
