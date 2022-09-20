package com.lucaslucena.teachermanagement.controllers;

import com.lucaslucena.teachermanagement.dto.StudentDto;
import com.lucaslucena.teachermanagement.models.StudentModel;
import com.lucaslucena.teachermanagement.services.StudentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    private ResponseEntity<StudentModel> saveStudent(@RequestBody StudentModel studentModel) {
        StudentModel createdStudent = studentService.saveStudent(studentModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(createdStudent.getId()).toUri();
        return ResponseEntity.created(uri).body(createdStudent);
    }

    @GetMapping
    private ResponseEntity<List<StudentDto>> findAllStudents() {
        return ResponseEntity.ok().body(studentService.findAllStudents());
    }

    @GetMapping("/{id}")
    private ResponseEntity<StudentDto> findStudentById(@PathVariable Long id) {
        return ResponseEntity.ok(studentService.findStudentById(id));
    }


}
