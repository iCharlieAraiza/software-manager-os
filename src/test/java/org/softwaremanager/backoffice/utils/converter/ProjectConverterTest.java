package org.softwaremanager.backoffice.utils.converter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.dto.ProjectDto;
import org.softwaremanager.backoffice.manager.projects.domain.dto.ProjectInfoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;

import static org.junit.jupiter.api.Assertions.*;

class ProjectConverterTest {
    private ProjectConverter converter;

    @BeforeEach
    void beforeEach(){
        converter = new ProjectConverter();
    }

    @Test
    void covertToPtojectInfoDto(){
        Project project = new Project();
        project.setName("Test project");
        project.setDescription("This is a project test info Dto");
        ProjectInfoDto projectInfo = converter.toProjectInfoDto(project);
    }

    @Test
    void convertToProjectFromProjectInfoDto(){
        ProjectInfoDto projectInfoDto = new ProjectInfoDto();
        projectInfoDto.setName("Test dto project");
        Project project = converter.toProject(projectInfoDto);

        assertEquals("Test dto project", project.getName());

    }

    @Test
    void convertToProjectDto(){
        Project project = new Project();
        //project.setName("Test project");
        //project.setProjectDetails("This is a test project to convert to F");

        //ProjectDto projectDto = converter.toProjectDto(project);
        //assertEquals("Test project", projectDto.getProjectInfoDto().getName());
    }

}