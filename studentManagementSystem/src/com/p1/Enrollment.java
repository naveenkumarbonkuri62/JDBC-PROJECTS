package com.p1;
import java.sql.*;

public class Enrollment {
    public static void enrollStudent(int studentId, int courseId) {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "INSERT INTO Enrollments(student_id, course_id) VALUES(?, ?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1, studentId);
            ps.setInt(2, courseId);
            ps.executeUpdate(); // ✅ Fixed here
            System.out.println("Enrollment successful.");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    static void viewEnrollments() {
        try (Connection conn = DBConnection.getConnection()) {
            String sql = "SELECT s.name AS student_name, c.course_name AS course_name FROM Enrollments e " +
                         "JOIN Students s ON e.student_id = s.student_id " +
                         "JOIN Courses c ON e.course_id = c.course_id";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
            
            boolean found = false;
            while (rs.next()) {
                String student = rs.getString("student_name");
                String course = rs.getString("course_name");
                System.out.println(student + " enrolled in " + course);
                found = true;
            }
            if (!found) {
                System.out.println("No enrollments found.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
