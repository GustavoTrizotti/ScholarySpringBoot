package com.api.scholary.services;

import com.api.scholary.models.StudentModel;
import com.api.scholary.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

@Service
public class StudentService {
    final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Transactional
    public StudentModel save(StudentModel studentModel) {
        return studentRepository.save(studentModel);
    }
}
