package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.nt.sbean.UserBean;

import jakarta.servlet.ServletContext;

public class UserLoginDao {
	
	public UserBean userLogin(String username,String password) {
		UserBean u1=null;
		
		try(Connection con=DBConnection.getCon();
				PreparedStatement pstmt=con.prepareStatement("SELECT * FROM USERTABLE WHERE USERNAME=? AND PASSWORD=?");
				){
			pstmt.setString(1, username);
			pstmt.setString(2, password);
			ResultSet rs=pstmt.executeQuery();
			if(rs.next()) {
				
				u1=new UserBean();
				u1.setuId(rs.getInt(1));
				u1.setuName(rs.getString(2));
				u1.setuAadharNo(rs.getString(3));
				u1.setuAddress(rs.getString(4));
				u1.setuLocation(rs.getString(5));
				u1.setuMobileNO(rs.getString(6));
				u1.setUsername(rs.getString(7));
				u1.setuPassword(rs.getString(8));
				
				
				
			}
			
		}
		catch (Exception e) {
			e.printStackTrace();
		}
		return u1;
	}

}
