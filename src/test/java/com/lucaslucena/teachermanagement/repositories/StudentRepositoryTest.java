package com.lucaslucena.teachermanagement.repositories;

import com.lucaslucena.teachermanagement.models.StudentModel;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.ArrayList;
import java.util.List;


@DataJpaTest
@TestInstance(TestInstance.Lifecycle.PER_METHOD)
class StudentRepositoryTest {

    @Autowired
    private StudentRepository repository;

    @AfterEach
    void tearDown() {
        repository.deleteAll();
    }

    @Test
    void shouldReturnTrueWhenEmailExists() {
        List<StudentModel> students = new ArrayList<>(List.of(
                new StudentModel("Lucas", "lucas.lucenak@gmail.com"),
                new StudentModel("Daniel", "daniel@gmail.com")
        ));
        repository.saveAll(students);
        String email = "lucas.lucenak@gmail.com";
        Assertions.assertEquals(true, repository.selectExistsByEmail(email));

    }

    @Test
    void shouldReturnFalseWhenEmailDoesNotExists() {
        List<StudentModel> students = new ArrayList<>(List.of(
                new StudentModel("Lucas", "lucas.lucenak@gmail.com"),
                new StudentModel("Daniel", "daniel@gmail.com")
        ));
        repository.saveAll(students);

        String email = "felipe@gmail.com";
        Assertions.assertEquals(false, repository.selectExistsByEmail(email));

    }

    @Test
    void shouldFindAllStudents() {
        List<StudentModel> students = new ArrayList<>(List.of(
                new StudentModel("Lucas", "lucas.lucenak@gmail.com"),
                new StudentModel("Daniel", "daniel@gmail.com")

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

        StudentModel student1 = new StudentModel("Lucas", "lucas.lucenak@gmail.com");
        StudentModel student2 = new StudentModel("Daniel", "daniel@gmail.com");
        List<StudentModel> students = new ArrayList<>(List.of(student1, student2));

        repository.saveAll(students);

        // Getting student by id
        var foundStudent = repository.findById(1L).get();
        System.out.println(foundStudent.getId());
        System.out.println(foundStudent.getName());

        Assertions.assertEquals(student1, foundStudent);

    }

}