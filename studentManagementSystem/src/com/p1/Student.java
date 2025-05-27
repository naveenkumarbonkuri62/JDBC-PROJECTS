package com.p1;
import java.sql.*;

public class Student {
	public static void addStudent(String name, String email) {
		try(Connection conn = DBConnection.getConnection()){
			String sql = "insert into Students(name,email) values(?,?)";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, email);
			ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void viewStudents() {
		try(Connection conn = DBConnection.getConnection()){
			String sql = "SELECT * FROM Students";
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);
			
			while(rs.next()) {
				System.out.println(rs.getInt("student_id") + " - " + rs.getString("name")+ " - " +rs.getString("email"));
			
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
