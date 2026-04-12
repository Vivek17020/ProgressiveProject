package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Student;



import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDAOImpl implements StudentDAO {


    private static List<Student> studentList = new ArrayList<>();
    private static int idCounter = 1;

    @Override
    public int addStudent(Student student) throws SQLException {
        student.setStudentId(idCounter++);
        studentList.add(student);
        return 1;
    }

    @Override
    public Student getStudentById(int studentId) throws SQLException {
        return studentList.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateStudent(Student student) throws SQLException {
        // ✅ no-op
    }

    @Override
    public void deleteStudent(int studentId) throws SQLException {
        studentList.removeIf(s -> s.getStudentId() == studentId);
    }

    @Override
    public List<Student> getAllStudents() throws SQLException {
        return studentList;
    }
}


