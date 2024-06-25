package com.nt.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public static final String url="jdbc:oracle:thin:@localhost:1521:xe";
	public static final String username="JAVA27";
	public static final String password="ORACLE";
	
	static {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	public static Connection getCon()throws Exception{
		return DriverManager.getConnection(url,username,password);
		
	}
			

}
