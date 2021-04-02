package org.softwaremanager.backoffice.manager.bootstrap;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.Status;
import org.softwaremanager.backoffice.manager.projects.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Component
public class BootStrapData implements CommandLineRunner {
    @Autowired
    ProjectRepository projectRepository;

    @Override
    public void run(String... args) throws Exception {
        initProjectData();
    }

    public void initProjectData() throws ParseException {
        SimpleDateFormat DATE_FORMAT = new SimpleDateFormat("yyyy-MM-dd");
        SimpleDateFormat DATE_TIME_FORMAT = new SimpleDateFormat("yyyy-MM-dd HH");


        Project projectA = new Project("Gestor de software",
                "Software dedicado par la gestión de proyectos de software");
        projectA.setStatus(Status.ACTIVE);
        projectA.setStartDate(new Date());
        projectRepository.save(projectA);
    }
}
