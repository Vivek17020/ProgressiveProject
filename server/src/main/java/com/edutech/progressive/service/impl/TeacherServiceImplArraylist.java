package com.edutech.progressive.service.impl;

<<<<<<< HEAD
public class TeacherServiceImplArraylist  {

=======

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Teacher;

public class TeacherServiceImplArraylist {

    private static List<Teacher> teacherList = new ArrayList<>();

    // Retrieves all teachers from the list
    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    // Adds a new teacher to the list and returns the current size
    public Integer addTeacher(Teacher teacher) {
        teacherList.add(teacher);
        return teacherList.size();
    }

    // Returns all teachers sorted by years of experience
    public List<Teacher> getTeacherSortedByExperience() {
        List<Teacher> sortedList = new ArrayList<>(teacherList);
        Collections.sort(sortedList); // uses Teacher.compareTo()
        return sortedList;
    }

    // Clears all teachers from the list
    public void emptyArrayList() {
        teacherList = new ArrayList<>();
    }
>>>>>>> a620306e1a8595f58f09e291e62fe35606b4afd0
}