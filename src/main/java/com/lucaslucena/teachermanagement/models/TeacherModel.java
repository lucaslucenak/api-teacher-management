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
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
//    @SequenceGenerator(name="student_id_generator", sequenceName = "student_id_sequence", allocationSize=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String occupation_area;

    @Column
    private String graduation;
}
