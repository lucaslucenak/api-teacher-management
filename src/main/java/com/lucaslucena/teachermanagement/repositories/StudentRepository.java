package com.lucaslucena.teachermanagement.repositories;

import com.lucaslucena.teachermanagement.models.StudentModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<StudentModel, Long> {
}