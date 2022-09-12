package com.lucaslucena.teachermanagement.dto;

import com.lucaslucena.teachermanagement.models.StudentModel;

public class StudentDto {

    private Long id;

    private String name;

    public StudentDto(StudentModel studentModel) {
        this.id = studentModel.getId();
        this.name = studentModel.getName();
    }

    public StudentDto(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public StudentDto() {
    }
}
