package com.lucaslucena.teachermanagement.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel {

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
//    @SequenceGenerator(name="student_id_generator", sequenceName = "student_id_sequence", allocationSize=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    public StudentModel(String name) {
        this.name = name;
    }
}
