package com.lucaslucena.teachermanagement.dto;

import com.lucaslucena.teachermanagement.models.TeacherModel;

public class TeacherDto {

    private Long id;

    private String name;

    private String occupation_area;

    private String graduation;

    public TeacherDto(TeacherModel teacherModel) {
        this.id = teacherModel.getId();
        this.name = teacherModel.getName();
        this.occupation_area = teacherModel.getOccupation_area();
        this.graduation = teacherModel.getGraduation();
    }

    public TeacherDto(Long id, String name, String occupation_area, String graduation) {
        this.id = id;
        this.name = name;
        this.occupation_area = occupation_area;
        this.graduation = graduation;
    }

    public TeacherDto() {
    }
}
