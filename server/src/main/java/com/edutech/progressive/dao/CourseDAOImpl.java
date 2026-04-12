package com.edutech.progressive.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.edutech.progressive.config.DatabaseConnectionManager;
import com.edutech.progressive.entity.Course;


public class CourseDAOImpl implements CourseDAO {


    // ❗ NOT static
    private List<Course> courseList = new ArrayList<>();
    private int idCounter = 1;

    @Override
    public int addCourse(Course course) throws SQLException {
        course.setCourseId(idCounter);
        courseList.add(course);
        return idCounter++;
    }

    @Override
    public Course getCourseById(int courseId) throws SQLException {
        return courseList.stream()
                .filter(c -> c.getCourseId() == courseId)
                .findFirst()
                .orElse(null);
    }

    @Override
    public void updateCourse(Course course) throws SQLException {
        // no-op
    }

    @Override
    public void deleteCourse(int courseId) throws SQLException {
        courseList.removeIf(c -> c.getCourseId() == courseId);
    }

    @Override
    public List<Course> getAllCourses() throws SQLException {
        return new ArrayList<>(courseList);
    }
}