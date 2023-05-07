package com.siit.jdbc;

import com.siit.jdbc.Student;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class JDBCExample {
    public static final String JDBC_DRIVER = "org.postgresql.Driver";
    static final String DB_URL = "jdbc:postgresql://localhost:5432/mydb";
    static final String USER = "postgres";
    static final String PASS = "root";

    public static void main(String[] args) {

        int MAX_RESULTS = 10;


        Connection conn = null;
        Statement stmt = null;
        PreparedStatement preparedStatement = null;
        try {
            Class.forName(JDBC_DRIVER);
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
            String sql = "SELECT id, name, course_id FROM students; SELECT email, password FROM users;";

            ResultSet resultSet = stmt.executeQuery(sql);

            List<Student> students = new ArrayList<>();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                int course_id = resultSet.getInt("course_id");
                Student student = new Student(id, name, course_id);
                students.add(student);
            }

            for (Student student : students) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Course ID: " + student.getCourseId());
            }

            resultSet.close();
            stmt.close();
            conn.close();
        } catch (SQLException se) {
            se.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                if (stmt != null)
                    stmt.close();
            } catch (SQLException se2) {
            }
            try {
                if (conn != null)
                    conn.close();
            } catch (SQLException se) {
                se.printStackTrace();
            }
        }
        System.out.println("Goodbye!");
    }
}

