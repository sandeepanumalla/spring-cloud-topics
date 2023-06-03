package com.infybuzz.controller;

import com.infybuzz.request.CreateStudentRequest;
import com.infybuzz.response.StudentResponse;
import com.infybuzz.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/student")
public class StudentController {


    private final StudentService studentService;

    @Autowired
    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping("/create")
    public StudentResponse createStudent (@RequestBody CreateStudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getById(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

}
