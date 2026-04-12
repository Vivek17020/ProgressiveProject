package com.edutech.progressive.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import com.edutech.progressive.dto.StudentDTO;
import com.edutech.progressive.entity.Student;

public class StudentServiceImplJpa  {


    // Simulated database
    private List<Student> studentDb = new ArrayList<>();
    private int idCounter = 1;

    // Retrieves all students
    public List<Student> getAllStudents() throws Exception {
        return studentDb;
    }

    // Adds a student and returns generated ID
    public Integer addStudent(Student student) throws Exception {
        student.setStudentId(idCounter++);
        studentDb.add(student);
        return student.getStudentId();
    }

    // Retrieves students sorted by name
    public List<Student> getAllStudentSortedByName() throws Exception {
        List<Student> sortedList = new ArrayList<>(studentDb);
        Collections.sort(sortedList);
        return sortedList;
    }

    // Updates student details
    public void updateStudent(Student student) throws Exception {
        for (Student s : studentDb) {
            if (s.getStudentId() == student.getStudentId()) {
                s.setFullName(student.getFullName());
                s.setDateOfBirth(student.getDateOfBirth());
                s.setContactNumber(student.getContactNumber());
                s.setEmail(student.getEmail());
                s.setAddress(student.getAddress());
                break;
            }
        }
    }

    // Deletes student by ID
    public void deleteStudent(int studentId) throws Exception {
        studentDb.removeIf(s -> s.getStudentId() == studentId);
    }

    // Retrieves student by ID
    public Student getStudentById(int studentId) throws Exception {
        return studentDb.stream()
                .filter(s -> s.getStudentId() == studentId)
                .findFirst()
                .orElse(null);
    }

    // Updates student using DTO (placeholder)
    public void modifyStudentDetails(StudentDTO studentDTO) {
        // Not implemented for Day‑5
    }
}
