package com.lucaslucena.teachermanagement.services;

import com.lucaslucena.teachermanagement.models.StudentModel;
import com.lucaslucena.teachermanagement.repositories.StudentRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

@ExtendWith(MockitoExtension.class)
class StudentServiceTest {

    @Mock
    private StudentRepository repository;
    private StudentService underTest;

    @BeforeEach
    void setUp() {
        underTest = new StudentService(repository);
    }

    @Test
    void saveStudent() {
        StudentModel studentModel = new StudentModel("Lucas", "lucas.lucenak@gmail.com");
        underTest.saveStudent(studentModel);

        ArgumentCaptor<StudentModel> studentModelArgumentCaptor = ArgumentCaptor.forClass(StudentModel.class);
        Mockito.verify(repository).save(studentModelArgumentCaptor.capture());
        StudentModel capturedStudent = studentModelArgumentCaptor.getValue();
        Assertions.assertEquals(studentModel, capturedStudent);
    }

    @Test
    void shouldFindAllStudents() {
        underTest.findAllStudents();
        Mockito.verify(repository).findAll();
    }

    @Test
    @Disabled
    void findStudentById() {
        StudentModel studentModel = new StudentModel("Lucas", "lucas.lucenak@gmail.com");
        underTest.saveStudent(studentModel);
        Mockito.verify(repository).findById(studentModel.getId());
    }

    @Test
    @Disabled
    void deleteStudentById() {
    }
}