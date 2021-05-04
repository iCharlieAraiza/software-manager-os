package org.softwaremanager.backoffice.manager.projects.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.softwaremanager.backoffice.manager.tasks.domain.Task;

import javax.persistence.*;
import java.util.*;

@Entity
@Data
@EqualsAndHashCode(exclude="tasks")

public class Project {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String description;
    private Date startDate;
    private Date endDate;

    @Column(name="remote_repository_url")
    private String remoteRepositoryUrl;
    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Task> tasks = new HashSet<>();


    private String status_project = "ACTIVE";

    public Project(){
        this.startDate = new Date();
    }

    @Override
    public String toString() {
        return "Project{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", remoteRepositoryUrl='" + remoteRepositoryUrl + '\'' +
                ", status_project='" + status_project + '\'' +
                '}';
    }
}
