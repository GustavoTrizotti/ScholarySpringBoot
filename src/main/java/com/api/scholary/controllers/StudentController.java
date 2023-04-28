package com.api.scholary.controllers;

import com.api.scholary.dto.StudentDto;
import com.api.scholary.models.StudentModel;
import com.api.scholary.services.StudentService;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("/student")
public class StudentController {
    final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ResponseEntity<Object> saveStudent(@RequestBody @Valid StudentDto studentDto) {
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }
}
