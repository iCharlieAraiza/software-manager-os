package org.softwaremanager.backoffice.manager.projects.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/project")
public class ProjectController {
    @GetMapping
    public String showProjects(){
        return "hola mundo";
    }
}
