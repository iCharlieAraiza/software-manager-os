package org.softwaremanager.backoffice.manager.projects.domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
public class ProjectDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String technologyFrontEnd;
    private String technologyBackEnd;
    private String infrastructure;
    private Integer hours;
    private Double budget;
    private String urlRepository;
    @ManyToOne
    @JoinColumn(name = "top_fk")
    private TypeOfProject top;
}
