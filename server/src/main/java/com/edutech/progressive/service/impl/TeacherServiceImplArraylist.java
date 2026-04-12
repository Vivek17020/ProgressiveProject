package com.edutech.progressive.service.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Teacher;

public class TeacherServiceImplArraylist {

   
    private List<Teacher> teacherList = new ArrayList<>();

    public List<Teacher> getAllTeachers() {
        return teacherList;
    }

    public Integer addTeacher(Teacher teacher) {
        teacherList.add(teacher);
        return teacherList.size();
    }

    public List<Teacher> getTeacherSortedByExperience() {
        List<Teacher> sorted = new ArrayList<>(teacherList);
        Collections.sort(sorted); // uses Comparable
        return sorted;
    }

    public void emptyArrayList() {
        teacherList = new ArrayList<>();
    }
}