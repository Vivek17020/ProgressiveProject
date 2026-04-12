package com.edutech.progressive.entity;

public class Course {
<<<<<<< HEAD

=======
    private int courseId;
    private String courseName;
    private String description;
    private int teacherId;

    public Course() {}

    public Course(int courseId, String courseName, String description, int teacherId) {
        this.courseId = courseId;
        this.courseName = courseName;
        this.description = description;
        this.teacherId = teacherId;
    }

    // Standard Getters and Setters
    
    public int getCourseId() { return courseId; }
    public void setCourseId(int courseId) { this.courseId = courseId; }
    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }
    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }
    public int getTeacherId() { return teacherId; }
    public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
>>>>>>> a620306e1a8595f58f09e291e62fe35606b4afd0
}