package org.softwaremanager.backoffice.manager.tasks.controller;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.softwaremanager.backoffice.manager.tasks.domain.Task;
import org.softwaremanager.backoffice.manager.tasks.repository.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@Controller
@RequestMapping("tasks")
public class TaskController {
    private TaskRepository taskRepository;
    private ProjectRepository projectRepository;

    public TaskController(TaskRepository taskRepository, ProjectRepository projectRepository) {
        this.taskRepository = taskRepository;
        this.projectRepository = projectRepository;
    }

    @GetMapping
    public String showProjects(Model model){
        List<Task> taskList = taskRepository.findAll();
        Collections.reverse(taskList);
        model.addAttribute("taskList", taskList);
        return "html/tasks";
    }

    @GetMapping("/create")
    public String newTask(Model model){
        Task task = new Task();
        List<Project> listProjects = projectRepository.findAll();
        model.addAttribute("projects", listProjects);
        model.addAttribute("task", task);
        return "html/task-form";
    }

    @PostMapping("/saveTask")
    public String saveTask(@ModelAttribute("task") Task task){
        taskRepository.save(task);
        return "redirect:/tasks";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable("id") Long id, Model model){
        Task task = taskRepository.findById(id).get();
        System.out.println(task);
        model.addAttribute("task", task);
        model.addAttribute("projects", projectRepository.findAll());
        return "html/task-form";
    }

    @GetMapping("/check/{id}")
    public String check(@PathVariable("id") Long id){
        Task task = taskRepository.findById(id).get();


        taskRepository.save(task);
        return "redirect:/tasks";
    }
}
