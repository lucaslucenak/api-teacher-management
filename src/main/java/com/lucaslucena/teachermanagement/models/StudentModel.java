package com.lucaslucena.teachermanagement.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_student")
public class StudentModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
    @SequenceGenerator(name="student_id_generator", sequenceName = "student_id_sequence", allocationSize=50)
    private Long id;

    @Column
    private String name;
}
