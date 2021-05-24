package org.softwaremanager.backoffice.utils.converter;

import org.modelmapper.ModelMapper;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;
import org.softwaremanager.backoffice.manager.projects.domain.dto.ProjectDto;
import org.softwaremanager.backoffice.manager.projects.domain.dto.ProjectInfoDto;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProjectConverter {
    ModelMapper modelMapper;

    public ProjectConverter(){
        modelMapper = new ModelMapper();
    }

    public ProjectDto toProjectDto(Project project) {
        ProjectDto dto = new ProjectDto();
        ProjectInfoDto projectInfoDto;
        List<String> emails;
        ProjectDetails projectDetails;
        return null;
    }

    public ProjectInfoDto toProjectInfoDto(Project project) {
        ProjectInfoDto dto = modelMapper.map(project, ProjectInfoDto.class);
        System.out.println(dto.toString());

        return null;
    }

    public Project toProject(ProjectInfoDto projectInfoDto) {
        return modelMapper.map(projectInfoDto, Project.class);
    }
}
