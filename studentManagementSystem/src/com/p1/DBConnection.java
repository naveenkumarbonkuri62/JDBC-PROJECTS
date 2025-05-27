package com.p1;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
	public  static Connection getConnection() {
		Connection conn = null;
		
		try {
			String url = "jdbc:mysql://localhost:3306/StudentCourseDB";
			String user = "root";
			String password="Naveen@6283";
			conn = DriverManager.getConnection(url,user,password);
		}catch(Exception e) {
			e.printStackTrace();
		}
		return conn;
	}
	

}
