package com.lucaslucena.teachermanagement.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "tb_project")
public class ProjectModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "project_id_generator")
    @SequenceGenerator(name="project_id_generator", sequenceName = "project_id_sequence", allocationSize=50)
    private Long id;
}
