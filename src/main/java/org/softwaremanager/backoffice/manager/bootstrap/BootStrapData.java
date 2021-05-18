package org.softwaremanager.backoffice.manager.bootstrap;

import org.softwaremanager.backoffice.auth.domain.User;
import org.softwaremanager.backoffice.auth.repository.UserRepository;
import org.softwaremanager.backoffice.auth.service.UserServiceImpl;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;
import org.softwaremanager.backoffice.manager.projects.domain.TypeOfProject;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.softwaremanager.backoffice.manager.projects.repository.TypeOfProjectRepository;
import org.softwaremanager.backoffice.manager.tasks.domain.Task;
import org.softwaremanager.backoffice.manager.tasks.repository.TaskRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Collections;
import java.util.Set;


@Component
public class BootStrapData implements CommandLineRunner {
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    TaskRepository taskRepository;

    @Autowired
    TypeOfProjectRepository topRepository;

    @Autowired
    UserServiceImpl userService;

    @Autowired
    UserRepository userRepository;


    @Override
    public void run(String... args) throws Exception {
        //createProject();
        //initProjectData();
        //testDelete();

        //showTasks();

        //initTop();
        //initProject();
        taskAndUser();
    }

    public void showTasks(){
        //List<Task> tasks = taskRepository.findAll();
        //for(Task task : tasks){
        //    System.out.println(task.getProject().getName());
        //    System.out.println(task.getPriority());
        //}
    }

    public void initProjectData() throws ParseException {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH");


        //Project projectA = new Project("Gestor de software",
                //"Software dedicado par la gestión de proyectos de software");
        //projectA.setStatus(ProjectStatus.ACTIVE);
        //projectA.setStartDate(new Date());
        //projectRepository.save(projectA);

        //List<Project> projects = projectRepository.findAll();
        //List<Task> tasks = taskRepository.findAll();

        Task task = new Task("Buscar solucionar el problema");
        //task.setProject(projects.get(0));

        //System.out.println(projects.get(0).getName());
        //task.setStartDate(new Date());
        taskRepository.save(task);
    }

    public void createProject(){
        //Project project = new Project("Gestor de software",
             //   "Sistema de desarrollo de software de código abierto");
        //project.setStartDate(new Date());
        //projectRepository.save(project);
    }

    public void mapTasksInProjects(){
        //List<Project> projects = projectRepository.findAll();
        //Project project = projects.get(0);
        //System.out.println(project.getName());
        //System.out.println(project.getTasks().get(0).getName());
        //List<Task> tasks = taskRepository.findAll();


    }

    public void testDelete(){
        //Project project = projectRepository.findById(5L).get();
        //System.out.println(project.getName());

        //projectRepository.delete(project);
    }

    public void initTop(){
        TypeOfProject top = new TypeOfProject();
        top.setName("Software");
        top.setDescription("Software and development project");

        topRepository.save(top);

    }

    public void initProject(){
        Project project = new Project();
        ProjectDetails details = new ProjectDetails();
        TypeOfProject top = topRepository.getOne(1L);

        details.setTop( top );
        details.setHours(69);
        project.setName( "Bugtracker component" );
        project.setProjectDetails( details );
        project.setDescription( "This is a test project" );

        projectRepository.save( project );
    }

    public void taskAndUser(){
        User currentUser = userRepository.findByEmail("Bambuchas");
        Project project = projectRepository.findById(1L).get();
        project.setUsersByProjects(Collections.singletonList(currentUser));

        projectRepository.save(project);
    }


}