package com.p1;
import java.sql.*;

public class Course {
    public static void addCourse(String courseName) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Courses(course_name) VALUES(?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setString(1, courseName);
            ps.executeUpdate();  
            System.out.println("Course added successfully.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void viewCourses() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT * FROM Courses";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);

            while (rs.next()) {
                System.out.println(rs.getInt("course_id") + " - " + rs.getString("course_name"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
