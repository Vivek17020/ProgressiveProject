package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Student;
import com.edutech.progressive.service.StudentService;
import com.edutech.progressive.service.impl.StudentServiceImplArraylist;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import java.util.List;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/student")
public class StudentController {

    private final StudentService studentService;
    private final StudentServiceImplArraylist arraylistService;

    public StudentController(StudentService studentService,
                             StudentServiceImplArraylist arraylistService) {
        this.studentService = studentService;
        this.arraylistService = arraylistService;
    }

    // GET /student
    @GetMapping
    public List<Student> getAllStudents() throws Exception {
        return studentService.getAllStudents();
    }

    // GET /student/{studentId}
    @GetMapping("/{studentId}")
    public Student getStudentById(@PathVariable int studentId) throws Exception {
        return studentService.getStudentById(studentId);
    }

    // GET /student/fromArrayList
    @GetMapping("/fromArrayList")
    public List<Student> getAllStudentFromArrayList() {
        return arraylistService.getAllStudents();
    }

    // GET /student/fromArrayList/sorted
    @GetMapping("/fromArrayList/sorted")
    public List<Student> getAllStudentSortedByNameFromArrayList() {
        return arraylistService.getAllStudentSortedByName();
    }

    // POST /student
    @PostMapping
    public int addStudent(@RequestBody Student student) throws Exception {
        return studentService.addStudent(student);
    }

    // POST /student/toArrayList
   @PostMapping("/toArrayList")
public ResponseEntity<Integer> addStudentToArrayList(@RequestBody Student student) {
    int result = arraylistService.addStudent(student);
    return new ResponseEntity<>(result, HttpStatus.CREATED);
}

    // PUT /student/{studentId}
    @PutMapping("/{studentId}")
    public void updateStudent(@PathVariable int studentId,
                              @RequestBody Student student) throws Exception {
        student.setStudentId(studentId);
        studentService.updateStudent(student);
    }

    // DELETE /student/{studentId}
    @DeleteMapping("/{studentId}")
    public void deleteStudent(@PathVariable int studentId) throws Exception {
        studentService.deleteStudent(studentId);
    }
}
