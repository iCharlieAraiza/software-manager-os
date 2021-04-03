package org.softwaremanager.backoffice.manager.tasks.domain;

import org.softwaremanager.backoffice.manager.projects.domain.Project;

import javax.persistence.*;
import java.util.Date;

@Entity
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Lob
    private String description;
    @Enumerated(EnumType.ORDINAL)
    private TaskStatus status;
    private Date startDate;
    @Temporal(TemporalType.TIME)
    private Date finishDate;

    @ManyToOne
    @JoinColumn(name = "project_id")
    private Project project;

    public Task(){ }

    public Task(String name) {
        this.name = name;
        this.status = TaskStatus.INCOMPLETE;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getFinishDate() {
        return finishDate;
    }

    public void setFinishDate(Date finishDate) {
        this.finishDate = finishDate;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
