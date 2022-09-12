package com.lucaslucena.teachermanagement.models;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_teacher")
public class TeacherModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "teacher_id_generator")
    @SequenceGenerator(name="teacher_id_generator", sequenceName = "teacher_id_sequence", allocationSize=50)
    private Long id;

    @Column
    private String name;

    @Column
    private String occupation_area;

    @Column
    private String graduation;
}
