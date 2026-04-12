package com.edutech.progressive.controller;

import com.edutech.progressive.entity.Course;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/course")
public class CourseController {

    @GetMapping
    public List<Course> getAllCourses() {
        return null;
    }

    @GetMapping("/{courseId}")
    public Course getCourseById(@PathVariable int courseId) {
        return null;
    }

    @PostMapping
    public int addCourse(@RequestBody Course course) {
        return -1;
    }

    @PutMapping("/{courseId}")
    public void updateCourse(@PathVariable int courseId,
                             @RequestBody Course course) {
    }

    @DeleteMapping("/{courseId}")
    public void deleteCourse(@PathVariable int courseId) {
    }

    @GetMapping("/teacher/{teacherId}")
    public List<Course> getAllCourseByTeacherId(@PathVariable int teacherId) {
        return null;
    }
}
