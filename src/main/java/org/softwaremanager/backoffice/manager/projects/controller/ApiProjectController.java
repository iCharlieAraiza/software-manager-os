package org.softwaremanager.backoffice.manager.projects.controller;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("api/project")
public class ApiProjectController {

    ProjectRepository repository;

    public ApiProjectController(ProjectRepository repository) {
        this.repository = repository;
    }

    @GetMapping
    public List<Project> showProjects(){
        List<Project> projects = new ArrayList<>();
        projects = repository.findAll();
        return projects;
    }
}
