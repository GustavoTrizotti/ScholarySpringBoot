package com.api.scholary.repositories;

import com.api.scholary.models.StudentModel;
import org.springframework.data.domain.Example;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, UUID> {
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
