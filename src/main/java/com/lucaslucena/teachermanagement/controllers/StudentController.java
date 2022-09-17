package com.lucaslucena.teachermanagement.controllers;

import com.lucaslucena.teachermanagement.dto.StudentDto;
import com.lucaslucena.teachermanagement.models.StudentModel;
import com.lucaslucena.teachermanagement.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping
    private StudentDto saveStudent(@RequestBody StudentModel studentModel) {
        studentService.saveStudent(studentModel);
        return new StudentDto(studentModel);
    }
}
