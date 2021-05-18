package org.softwaremanager.backoffice.manager.tasks.domain;

import lombok.Data;
import org.softwaremanager.backoffice.manager.projects.domain.Project;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Lob
    private String description;

    @Enumerated
    private TaskStatus status;

    @Enumerated
    private Priority priority;

    private Integer planTime;

    private Integer actualTime;

    @Temporal(TemporalType.TIME)
    private Date startDate;

    @Temporal(TemporalType.TIME)
    private Date endDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task(){
    }

    public Task(String name) {
        this.name = name;
    }

}