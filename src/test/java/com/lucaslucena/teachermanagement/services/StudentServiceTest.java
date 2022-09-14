package com.lucaslucena.teachermanagement.services;

import com.lucaslucena.teachermanagement.repositories.StudentRepository;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;
    private StudentService service;

    @BeforeEach
    void setUp() {
        service = new StudentService(repository);
    }

    @Test
    @Disabled
    void saveStudent() {
    }

    @Test
    void shouldFindAllStudents() {
        service.findAllStudents();
        Mockito.verify(repository).findAll();
    }

    @Test
    @Disabled
    void findStudentById() {
    }

    @Test
    @Disabled
    void deleteStudentById() {
    }
}