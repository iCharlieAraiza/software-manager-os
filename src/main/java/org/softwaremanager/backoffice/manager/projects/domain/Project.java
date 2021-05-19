package org.softwaremanager.backoffice.manager.projects.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.softwaremanager.backoffice.auth.domain.Role;
import org.softwaremanager.backoffice.auth.domain.User;
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

    @Enumerated
    private Status status;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "project_details_fk")
    private ProjectDetails projectDetails;


    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="projects_users",
            joinColumns = @JoinColumn(
                    name = "project_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(
                    name = "user_id", referencedColumnName = "id")
    )
    private Collection<User> usersByProjects;


    @ToString.Exclude
    @OneToMany(fetch = FetchType.EAGER, mappedBy = "project", cascade = CascadeType.ALL)
    @JsonIgnore
    Set<Task> tasks = new HashSet<>();



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
                '}';
    }
}
