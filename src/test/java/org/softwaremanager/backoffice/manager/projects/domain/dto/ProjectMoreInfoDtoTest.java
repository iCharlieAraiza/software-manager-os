package org.softwaremanager.backoffice.manager.projects.domain.dto;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.softwaremanager.backoffice.manager.projects.domain.Project;

import static org.junit.jupiter.api.Assertions.*;


class ProjectMoreInfoDtoTest {
    private ProjectMoreInfoDto projectMoreInfoDto;
    @BeforeEach
    void beforeEach(){
        projectMoreInfoDto = new ProjectMoreInfoDto();
    }

    @Test
    void showToStringComponent(){
        System.out.println( projectMoreInfoDto.toString() );
    }

    @Test
    void initProjectMoreInfoByProject(){
        Project project = new Project();
        project.setName("Project test name");
        ProjectMoreInfoDto test = new ProjectMoreInfoDto(project);

        assertEquals("Project test name", test.getProjectInfo().getName());
    }
}