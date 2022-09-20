package com.lucaslucena.teachermanagement.models;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import javax.persistence.*;
import java.io.Serial;
import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "tb_student")
@AllArgsConstructor
@NoArgsConstructor
public class StudentModel implements Serializable {

    @Serial
    private static final long serialVersionUID = 1L;

    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "student_id_generator")
//    @SequenceGenerator(name="student_id_generator", sequenceName = "student_id_sequence", allocationSize=50)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String email;

    public StudentModel(String name, String email) {
        this.name = name;
        this.email = email;
    }
}
