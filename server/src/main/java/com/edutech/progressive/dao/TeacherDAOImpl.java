package com.edutech.progressive.dao;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Teacher;


public class TeacherDAOImpl implements TeacherDAO {


   
    private final List<Teacher> teacherList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public int addTeacher(Teacher teacher) throws SQLException {
        teacher.setTeacherId(idCounter);
        teacherList.add(teacher);

        
        return idCounter++;
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws SQLException {
        for (Teacher t : teacherList) {
            if (t.getTeacherId() == teacherId) {
                return t;
            }
        }
        return null;
    }

    @Override
    public void updateTeacher(Teacher teacher) throws SQLException {
        
for (Teacher t : teacherList) {
        if (t.getTeacherId() == teacher.getTeacherId()) {
            t.setFullName(teacher.getFullName());
            t.setSubject(teacher.getSubject());
            t.setContactNumber(teacher.getContactNumber());
            t.setEmail(teacher.getEmail());
            t.setYearsOfExperience(teacher.getYearsOfExperience());
            break;
        }
    }

    }

    @Override
    public void deleteTeacher(int teacherId) throws SQLException {
        teacherList.removeIf(t -> t.getTeacherId() == teacherId);
    }

    @Override
    public List<Teacher> getAllTeachers() throws SQLException {
       
        return new ArrayList<>(teacherList);
    }
}