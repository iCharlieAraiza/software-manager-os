package org.softwaremanager.backoffice.manager.projects.domain;

import org.softwaremanager.backoffice.manager.tasks.domain.Task;

import javax.persistence.*;
import java.util.*;

@Entity
public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    @OneToMany(mappedBy = "project", cascade = CascadeType.ALL)
    Set<Task> tasks = new HashSet<>();


    @Enumerated(EnumType.ORDINAL)
    private ProjectStatus status;

    public Project(){}

    public Project(String name, Date startDate) {
        this.name = name;
        this.startDate = startDate;
    }

    public Project(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public ProjectStatus getStatus() {
        return status;
    }

    public void setStatus(ProjectStatus status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Task> getTasks() {
        return tasks;
    }

    public void setTasks(Set<Task> tasks) {
        this.tasks = tasks;
    }
}
