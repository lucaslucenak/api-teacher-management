package com.lucaslucena.teachermanagement.dto;

import com.lucaslucena.teachermanagement.models.StudentModel;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;

@Data
public class StudentDto implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

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
