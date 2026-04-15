package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Teacher;
import org.springframework.http.ResponseEntity;

import java.util.List;


import com.edutech.progressive.entity.Teacher;
import com.edutech.progressive.service.impl.TeacherServiceImplJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/teacher")
public class TeacherController {

    @Autowired
    private TeacherServiceImplJpa teacherServiceImplJpa;

    // GET /teacher
    @GetMapping
    public List<Teacher> getAllTeachers() throws Exception {
        return teacherServiceImplJpa.getAllTeachers();
    }

    // GET /teacher/{teacherId}
    @GetMapping("/{teacherId}")
    public Teacher getTeacherById(@PathVariable int teacherId) throws Exception {
        return teacherServiceImplJpa.getTeacherById(teacherId);
    }

    // POST /teacher
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Integer addTeacher(@RequestBody Teacher teacher) throws Exception {
        return teacherServiceImplJpa.addTeacher(teacher);
    }

    // PUT /teacher/{teacherId}
    @PutMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.OK)
    public void updateTeacher(@PathVariable int teacherId, @RequestBody Teacher teacher) throws Exception {
        teacher.setTeacherId(teacherId);
        teacherServiceImplJpa.updateTeacher(teacher);
    }

    // DELETE /teacher/{teacherId}
    @DeleteMapping("/{teacherId}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteTeacher(@PathVariable int teacherId) throws Exception {
        teacherServiceImplJpa.deleteTeacher(teacherId);
    }

    // GET /teacher/yearsofexperience
    @GetMapping("/yearsofexperience")
    public List<Teacher> getTeacherSortedByYearsOfExperience() throws Exception {
        return teacherServiceImplJpa.getTeacherSortedByExperience();
    }
}