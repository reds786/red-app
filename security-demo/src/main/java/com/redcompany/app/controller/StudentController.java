package com.redcompany.app.controller;

import com.redcompany.app.model.Student;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("api/v1/students")
public class StudentController {

    private static  final List<Student> STUDENTS = Arrays.asList(
            new Student(1, "Srinu Reddy"),
            new Student(2, "Shilpa Reddy"),
            new Student(3, "Pranvith Reddy"),
            new Student(4, "Sahithi Reddy")
    );

    @RequestMapping("{studentId}")
    public Student getStudent(@PathVariable("studentId") Integer  studentId){
        return STUDENTS
                .stream()
                .filter(student -> studentId.equals(student.getStudentId()))
                .findFirst()
                .orElseThrow(() -> new IllegalStateException(
                        "Student with id" + studentId + "not found"
                ));

    }

    @RequestMapping
    private List<Student> getStudents(){
        return STUDENTS;

    }

}
