package org.softwaremanager.backoffice.manager.projects.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwaremanager.backoffice.manager.projects.domain.Project;

import static org.junit.jupiter.api.Assertions.*;

class ProjectDtoTest {
    Project project;
    ProjectInfoDto projectInfoDto;
    ProjectDto projectDto;

    @BeforeEach
    void beforeEach(){
        project = new Project();
        project.setName("Project Test 1");
        project.setDescription("This is a project test example");

        this.projectDto = new ProjectDto();

    }

    @Test
    void createProjectDtoWithProjectinfo(){

        ProjectInfoDto projectInfoDto = new ProjectInfoDto( );
        ProjectDto projectDto = new ProjectDto();
        projectDto.setProjectInfoDto( projectInfoDto );

        assertEquals("Project Test 1", projectDto.getProjectInfoDto().getName() );
    }

    @Test
    void accessToaVoidElement(){
        assertNull(projectDto.getProjectInfoDto());
    }

    @Test
    void toProject(){
        //Project test = projectDto.toProject();
        //assertEquals("Project Test 1", test.getName());
    }

}
