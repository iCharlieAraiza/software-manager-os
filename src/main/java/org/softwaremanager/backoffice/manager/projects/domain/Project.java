package org.softwaremanager.backoffice.manager.projects.domain;

import lombok.Data;
import org.softwaremanager.backoffice.manager.tasks.domain.Task;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private String repositoryUrl;


    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    Set<Task> tasks = new HashSet<>();


    @Enumerated(EnumType.ORDINAL)
    private ProjectStatus status = ProjectStatus.ACTIVE;

    public Project(){
        this.startDate = new Date();
    }

    public Project(String name, Date startDate){
        this.name = name;
        this.startDate = startDate;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
        this.startDate = new Date();
    }
}
