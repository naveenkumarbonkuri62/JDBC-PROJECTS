package com.p1;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Student Course Management System ---");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Add Course");
            System.out.println("4. View Courses");
            System.out.println("5. Enroll Student in Course");
            System.out.println("6. View Enrollments");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter student name: ");
                    String name = sc.nextLine();
                    System.out.print("Enter email: ");
                    String email = sc.nextLine();
                    Student.addStudent(name, email);
                    break;

                case 2:
                    Student.viewStudents();
                    break;

                case 3:
                    sc.nextLine(); // consume leftover newline
                    System.out.print("Enter course name: ");
                    String courseName = sc.nextLine();
                    Course.addCourse(courseName);
                    break;

                case 4:
                    Course.viewCourses();
                    break;

                case 5:
                    System.out.print("Enter student ID: ");
                    int studentId = sc.nextInt();
                    System.out.print("Enter course ID: ");
                    int courseId = sc.nextInt();
                    Enrollment.enrollStudent(studentId, courseId);
                    break;

                case 6:
                    Enrollment.viewEnrollments();
                    break;

                case 0:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid option.");
            }

        } while (choice != 0);

        sc.close();
    }
}
