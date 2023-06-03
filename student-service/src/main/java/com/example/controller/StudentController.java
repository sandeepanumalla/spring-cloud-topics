package com.example.controller;

import com.example.request.StudentRequest;
import com.example.response.StudentResponse;
import com.example.service.StudentService;
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
    public StudentResponse createStudent (@RequestBody StudentRequest studentRequest) {
        return studentService.createStudent(studentRequest);
    }

    @GetMapping("/getById/{id}")
    public StudentResponse getById (@PathVariable long id) {
        return studentService.getById(id);
    }
}
