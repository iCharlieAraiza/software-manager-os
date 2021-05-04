package org.softwaremanager.backoffice.manager.projects.controller;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.softwaremanager.backoffice.manager.projects.service.ProjectServiceImp;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/project")
public class ProjectController {

    ProjectRepository projectRepository;

    public ProjectController(ProjectRepository projectRepository) {
        this.projectRepository = projectRepository;
    }

    @GetMapping("/create")
    private String showCreateProjects(Model model){
        Project project = new Project();
        model.addAttribute("project", project);
        return "html/project-form";
    }

    @PostMapping("/saveProject")
    public String saveProject(@ModelAttribute("category") Project project) {
        projectRepository.save(project);
        return "redirect:/";
    }


    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Project project = projectRepository.findById(id).get();
        model.addAttribute("project", project);
        return "html/project-form";
    }

}
