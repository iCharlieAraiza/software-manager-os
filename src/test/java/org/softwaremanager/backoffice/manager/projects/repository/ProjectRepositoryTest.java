package org.softwaremanager.backoffice.manager.projects.repository;

import org.junit.jupiter.api.Test;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class ProjectRepositoryTest {
    @Autowired
    private  ProjectRepository repository;

    @Test
    void createProject(){
        Project project = new Project();
        ProjectDetails details = new ProjectDetails();

        details.setHours(12);
        details.setBudget(2000.0);

        project.setName( "Bugtracker component" );
        project.setProjectDetails( details );
        project.setDescription( "This is a test project" );

        repository.save(project);
        Project test = repository.findAll().get(0);

        assertNotNull(test);
        System.out.println(test.toString());

    }


    void restFindProject(){
        Project project = repository.findAll().get(0);
        assertNotNull(project);
    }

}