package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.StudentDAO;
import com.edutech.progressive.dao.StudentDAOImpl;
import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;




public class StudentServiceImplJdbc implements StudentService {

    private StudentDAO studentDAO;

    // ✅ No-arg constructor (required)
    public StudentServiceImplJdbc() {
        this.studentDAO = new StudentDAOImpl();
    }

    // ✅ DAO-based constructor (used by tests)
    public StudentServiceImplJdbc(StudentDAO studentDAO) {
        this.studentDAO = studentDAO;
    }

    @Override
    public List<Student> getAllStudents() throws Exception {
        try {
            return studentDAO.getAllStudents();
        } catch (SQLException e) {
            throw new Exception("Error fetching students", e);
        }
    }

    @Override
    public Integer addStudent(Student student) throws Exception {
        try {
            return studentDAO.addStudent(student);
        } catch (SQLException e) {
            throw new Exception("Error adding student", e);
        }
    }

    @Override
    public void updateStudent(Student student) throws Exception {
        try {
            studentDAO.updateStudent(student);
        } catch (SQLException e) {
            throw new Exception("Error updating student", e);
        }
    }

    @Override
    public void deleteStudent(int studentId) throws Exception {
        try {
            studentDAO.deleteStudent(studentId);
        } catch (SQLException e) {
            throw new Exception("Error deleting student", e);
        }
    }

    @Override
    public Student getStudentById(int studentId) throws Exception {
        try {
            return studentDAO.getStudentById(studentId);
        } catch (SQLException e) {
            throw new Exception("Error fetching student", e);
        }
    }

    @Override
    public List<Student> getAllStudentSortedByName() throws Exception {
        List<Student> list = getAllStudents();
        Collections.sort(list); // uses Comparable<Student>
        return list;
    }

  
}