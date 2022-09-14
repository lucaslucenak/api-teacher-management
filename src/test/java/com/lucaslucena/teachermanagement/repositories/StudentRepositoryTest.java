package com.lucaslucena.teachermanagement.repositories;

import com.lucaslucena.teachermanagement.models.StudentModel;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @Test
    void shouldFindAllStudents() {
        List<StudentModel> students = new ArrayList<>(List.of(
                new StudentModel("Lucas"),
                new StudentModel("Daniel")

        ));

        repository.saveAll(students);

        // Getting all students
        var foundStudents = repository.findAll();
        System.out.println(foundStudents.get(0).getId());
        System.out.println(foundStudents.get(0).getName());

        Assertions.assertEquals(students, foundStudents);
    }

    @Test
    void shouldFindStudentById() {

        StudentModel student1 = new StudentModel("Lucas");
        StudentModel student2 = new StudentModel("Daniel");
        List<StudentModel> students = new ArrayList<>(List.of(student1, student2));

        repository.saveAll(students);

        // Getting student by id
        var foundStudent = repository.findById(1L).get();
        System.out.println(foundStudent.getId());
        System.out.println(foundStudent.getName());

        Assertions.assertEquals(student1, foundStudent);

    }

}