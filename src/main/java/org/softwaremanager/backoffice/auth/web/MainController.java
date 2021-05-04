package org.softwaremanager.backoffice.auth.web;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import java.util.Collections;
import java.util.List;

@Controller
public class MainController {
    private ProjectRepository projectRepository;

    public MainController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Project> listProjects = projectRepository.findAll();
        Collections.reverse(listProjects);
        model.addAttribute("listProjects", listProjects );
        return "html/projects";
    }
}
