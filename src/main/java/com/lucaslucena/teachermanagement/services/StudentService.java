package com.lucaslucena.teachermanagement.services;

import com.lucaslucena.teachermanagement.dto.StudentDto;
import com.lucaslucena.teachermanagement.exceptions.DatabaseException;
import com.lucaslucena.teachermanagement.exceptions.StudentNotFoundException;
import com.lucaslucena.teachermanagement.models.StudentModel;
import com.lucaslucena.teachermanagement.repositories.StudentRepository;
import org.apache.coyote.Response;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {

    private final StudentRepository repository;

    public StudentService(StudentRepository repository) {
        this.repository = repository;
    }

    public StudentModel saveStudent(StudentModel studentModel) {
        return repository.save(studentModel);
    }

    public List<StudentDto> findAllStudents() {
        return repository.findAll().stream().map(studentModel -> new StudentDto(studentModel)).toList();
    }

    public StudentModel findStudentById(Long id) {
        StudentModel studentModel = repository.findById(id).get();

        if (repository.findById(id).isEmpty()) {
            throw new StudentNotFoundException("Student not found");
        }
        else {
            return studentModel;
        }
    }

    public StudentModel updateStudentById(Long id, StudentModel studentModel) {
        StudentModel sourceStudent = findStudentById(id);
        sourceStudent.setName(studentModel.getName());
        sourceStudent.setEmail(studentModel.getEmail());
        return repository.save(sourceStudent);
    }

    public void deleteStudentById(Long id) {
        try {
            repository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new StudentNotFoundException("Student not found. Id: " + id);
        } catch (DataIntegrityViolationException e) {
            throw new DatabaseException("Database violation");
        }
    }
}
