package com.edutech.progressive.dao;

import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Student;
import java.sql.*;
import java.util.*;

public class StudentDAOImpl implements StudentDAO {

    @Override
    public int addStudent(Student student) {
        return 0;
        // String sql = "INSERT INTO students (name, email) VALUES (?, ?)";

        // try (Connection con = DatabaseConnectionManager.getConnection();
        //      PreparedStatement ps = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {

        //     ps.setString(1, student.getFullName());
        //     ps.setString(2, student.getEmail());
        //     ps.executeUpdate();

        //     ResultSet rs = ps.getGeneratedKeys();
        //     return rs.next() ? rs.getInt(1) : -1;

        // } catch (SQLException e) {
        //     throw new RuntimeException(e);
        }
    

    @Override
    public Student getStudentById(int studentId) {
        return null;
        // String sql = "SELECT * FROM students WHERE id = ?";

        // try (Connection con = DatabaseConnectionManager.getConnection();
        //      PreparedStatement ps = con.prepareStatement(sql)) {

        //     ps.setInt(1, studentId);
        //     ResultSet rs = ps.executeQuery();

        //     if (rs.next()) {
        //         return new Student(
        //                 rs.getInt("studentId"),
        //                 rs.getString("fullName"),
        //                 rs.getString("email")
        //         );
        //     }
        //     return null;

        // } catch (SQLException e) {
        //     throw new RuntimeException(e);
        // }
    }

    @Override
    public void updateStudent(Student student) {
    //     String sql = "UPDATE students SET name=?, email=? WHERE id=?";

    //     try (Connection con = DatabaseConnectionManager.getConnection();
    //          PreparedStatement ps = con.prepareStatement(sql)) {

    //         ps.setString(1, student.getFullName());
    //         ps.setString(2, student.getEmail());
    //         ps.setInt(3, student.getStudentId());
    //         ps.executeUpdate();

    //     } catch (SQLException e) {
    //         throw new RuntimeException(e);
    //     }
    // }

    // @Override
    // public void deleteStudent(int studentId) {
    //     String sql = "DELETE FROM students WHERE id=?";

    //     try (Connection con = DatabaseConnectionManager.getConnection();
    //          PreparedStatement ps = con.prepareStatement(sql)) {

    //         ps.setInt(1, studentId);
    //         ps.executeUpdate();

    //     } catch (SQLException e) {
    //         throw new RuntimeException(e);
    //     }
    }

    @Override
    public List<Student> getAllStudents() {
        return null;
        // List<Student> students = new ArrayList<>();
        // String sql = "SELECT * FROM students";

        // try (Connection con = DatabaseConnectionManager.getConnection();
        //      Statement st = con.createStatement();
        //      ResultSet rs = st.executeQuery(sql)) {

        //     while (rs.next()) {
        //         students.add(new Student(
        //                 rs.getInt("id"),
        //                 rs.getString("name"),
        //                 rs.getString("email")
        //         ));
        //     }
        //     return students;

        // } catch (SQLException e) {
        //     throw new RuntimeException(e);
        // }
    }


    @Override
    public void deleteStudent(int studentId) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteStudent'");
    }
}
