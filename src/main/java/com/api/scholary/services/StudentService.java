package com.api.scholary.services;

import com.api.scholary.models.StudentModel;
import com.api.scholary.repositories.StudentRepository;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

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

    public boolean existsByName(String name) {
        return studentRepository.existsByName(name);
    }

    public boolean existsByEmail(String email) {
        return studentRepository.existsByEmail(email);
    }

    public List<StudentModel> findAll() {
        return studentRepository.findAll();
    }

    public Optional<StudentModel> findById(UUID id) {
        return studentRepository.findById(id);
    }

    @Transactional
    public void delete(StudentModel studentModel) {
        studentRepository.delete(studentModel);
    }

}
