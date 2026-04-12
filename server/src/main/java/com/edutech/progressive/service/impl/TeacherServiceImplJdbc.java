package com.edutech.progressive.service.impl;

import java.sql.SQLException;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dao.TeacherDAO;
import com.edutech.progressive.dao.TeacherDAOImpl;
import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.TeacherService;


public class TeacherServiceImplJdbc implements TeacherService {

    private TeacherDAO teacherDAO;
    


    // ✅ REQUIRED no-arg constructor
    public TeacherServiceImplJdbc() {
        this.teacherDAO = new TeacherDAOImpl();
    }

  
    public TeacherServiceImplJdbc(TeacherDAO teacherDAO) {
        this.teacherDAO = teacherDAO;
    }


    @Override
    public List<Teacher> getAllTeachers() throws Exception {
        try {
            return teacherDAO.getAllTeachers();
        } catch (SQLException e) {
            throw new Exception("Unable to fetch teachers", e);
        }
    }

    @Override
    public Integer addTeacher(Teacher teacher) throws Exception {
        try {
            return teacherDAO.addTeacher(teacher);
        } catch (SQLException e) {
            throw new Exception("Unable to add teacher", e);
        }
    }

    @Override
    public void updateTeacher(Teacher teacher) throws Exception {
        try {
            teacherDAO.updateTeacher(teacher);
        } catch (SQLException e) {
            throw new Exception("Unable to update teacher", e);
        }
    }

    @Override
    public void deleteTeacher(int teacherId) throws Exception {
        try {
            teacherDAO.deleteTeacher(teacherId);
        } catch (SQLException e) {
            throw new Exception("Unable to delete teacher", e);
        }
    }

    @Override
    public Teacher getTeacherById(int teacherId) throws Exception {
        try {
            return teacherDAO.getTeacherById(teacherId);
        } catch (SQLException e) {
            throw new Exception("Unable to fetch teacher", e);
        }
    }

    @Override
    public List<Teacher> getTeacherSortedByExperience() throws Exception {
        List<Teacher> list = getAllTeachers();
        Collections.sort(list); // uses Comparable
        return list;
    }

    
}