package org.softwaremanager.backoffice.manager.projects.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class DeploymentVersion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String label;
    private Date date;
    private String description;
    private String urlRepository;
    @ManyToOne
    private Project project;
}
