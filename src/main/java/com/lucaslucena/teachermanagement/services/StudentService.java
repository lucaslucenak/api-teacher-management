package com.lucaslucena.teachermanagement.services;

import com.lucaslucena.teachermanagement.dto.StudentDto;
import com.lucaslucena.teachermanagement.exceptions.StudentNotFoundException;
import com.lucaslucena.teachermanagement.models.StudentModel;
import com.lucaslucena.teachermanagement.repositories.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class StudentService {

    @Autowired
    private StudentRepository repository;

    public StudentDto saveStudent(StudentModel studentModel) {
        StudentDto studentDto = new StudentDto(studentModel);
        repository.save(studentModel);
        return studentDto;
    }

    public List<StudentDto> findAllStudents() {
        return repository.findAll().stream().map(studentModel -> new StudentDto(studentModel)).toList();
    }

    public StudentDto findStudentById(Long id) {
        StudentModel studentModel = repository.findById(id).get();

        if (repository.findById(id).isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }
        else {
            return new StudentDto(studentModel);
        }
    }


}
