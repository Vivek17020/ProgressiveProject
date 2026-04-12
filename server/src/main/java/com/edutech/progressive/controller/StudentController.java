package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Student;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents() {
        return null;
    }

    @GetMapping("/{studentId}")
    public ResponseEntity<Student> getStudentById(@PathVariable int studentId) {
        return null;
    }

    @PostMapping
    public ResponseEntity<Integer> addStudent(@RequestBody Student student) {
        return null;
    }

    @PutMapping("/{studentId}")
    public ResponseEntity<Void> updateStudent(@PathVariable int studentId,
                                              @RequestBody Student student) {
        return null;
    }

    @DeleteMapping("/{studentId}")
    public ResponseEntity<Void> deleteStudent(@PathVariable int studentId) {
        return null;
    }

    @GetMapping("/fromArrayList")
    public ResponseEntity<List<Student>> getAllStudentFromArrayList() {
        return null;
    }

    @PostMapping("/toArrayList")
    public ResponseEntity<Void> addStudentToArrayList() {
        return null;
    }

    @GetMapping("/fromArrayList/sorted")
    public ResponseEntity<List<Student>> getAllStudentSortedByNameFromArrayList() {
        return null;
    }
}