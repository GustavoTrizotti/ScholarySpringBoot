package com.api.scholary.controllers;

import com.api.scholary.dto.StudentDto;
import com.api.scholary.models.StudentModel;
import com.api.scholary.services.StudentService;
import jakarta.validation.Valid;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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
        if (studentService.existsByName(studentDto.getName()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This name is already in use!");
        if (studentService.existsByEmail(studentDto.getEmail()))
            return ResponseEntity.status(HttpStatus.CONFLICT).body("Conflict: This email is already in use!");
        var studentModel = new StudentModel();
        BeanUtils.copyProperties(studentDto, studentModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(studentService.save(studentModel));
    }

    @GetMapping
    public ResponseEntity<List<StudentModel>> getAllStudents() {
        return ResponseEntity.status(HttpStatus.OK).body(studentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getStudentById(@PathVariable(value = "id") UUID id) {
        Optional<StudentModel> studentModelOptional = studentService.findById(id);
        return studentModelOptional.<ResponseEntity<Object>>map(studentModel ->
                ResponseEntity.status(HttpStatus.OK).body(studentModel)).orElseGet(() ->
                ResponseEntity.status(HttpStatus.NOT_FOUND).body("Student not found."));

    }
}
