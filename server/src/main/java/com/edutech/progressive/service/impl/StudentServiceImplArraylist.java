package com.edutech.progressive.service.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Student;

public class StudentServiceImplArraylist {

    // In-memory list storing students
    private static List<Student> studentList = new ArrayList<>();

    // Returns all students
    public List<Student> getAllStudents() {
        return studentList;
    }

    // Adds a student and returns list size
    public Integer addStudent(Student student) {
        studentList.add(student);
        return studentList.size();
    }

    // Returns students sorted by name
    public List<Student> getAllStudentSortedByName() {
        List<Student> sortedList = new ArrayList<>(studentList);
        Collections.sort(sortedList); // uses Comparable<Student>
        return sortedList;
    }

    // Clears the ArrayList
    public void emptyArrayList() {
        studentList.clear();
    }
}
