package org.softwaremanager.backoffice.manager.bootstrap;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectStatus;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.softwaremanager.backoffice.manager.tasks.domain.Task;
import org.softwaremanager.backoffice.manager.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Component
public class BootStrapData implements CommandLineRunner {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Override
    public void run(String... args) throws Exception {
        initProjectData();
        //createProject();
    }

    public void initProjectData() throws ParseException {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH");


        Project projectA = new Project("Gestor de software",
                "Software dedicado par la gestión de proyectos de software");
        //projectA.setStatus(ProjectStatus.ACTIVE);
        //projectA.setStartDate(new Date());
        //projectRepository.save(projectA);

        List<Project> projects = projectRepository.findAll();
        //List<Task> tasks = taskRepository.findAll();

        Task task = new Task("Buscar solucionar el problema");
        task.setProject(projects.get(0));

        //System.out.println(projects.get(0).getName());
        //task.setStartDate(new Date());
        taskRepository.save(task);
    }

    public void createProject(){
        Project project = new Project("Gestor de software",
                "Sistema de desarrollo de software de código abierto");
        project.setStartDate(new Date());
        projectRepository.save(project);
    }

}
