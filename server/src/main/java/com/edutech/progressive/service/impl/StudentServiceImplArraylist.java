package com.edutech.progressive.service.impl;



import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.entity.Student;

public class StudentServiceImplArraylist {

    // Holds the list of Student objects in memory
    private static List<Student> studentList = new ArrayList<>();

    // Returns the complete list of students
    public List<Student> getAllStudents() {
        return studentList;
    }

    // Adds a new Student to the list and returns the new size of the list
    public Integer addStudent(Student student) {
        studentList.add(student);
        return studentList.size();
    }

    // Returns the list of students sorted by their full name
    public List<Student> getAllStudentSortedByName() {
        List<Student> sortedList = new ArrayList<>(studentList);
        Collections.sort(sortedList); // uses Student.compareTo()
        return sortedList;
    }

    // Clears all students by reinitializing the list
    public void emptyArrayList() {
    }

}