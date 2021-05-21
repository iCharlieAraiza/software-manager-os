package org.softwaremanager.backoffice.manager.projects.domain.dto;

import lombok.Data;
import org.softwaremanager.backoffice.auth.web.dto.UserInfoDto;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.RequirementSpecification;
import org.softwaremanager.backoffice.manager.tasks.domain.Task;

import java.util.List;

@Data
public class ProjectMoreInfoDto {
    private ProjectInfoDto projectInfo;
    private List<Task> taskList;
    private List<UserInfoDto> listOfMembers;
    private RequirementSpecification requirementSpecification;
    private Project details;

    public ProjectMoreInfoDto(){}

    public ProjectMoreInfoDto(Project project){
        projectInfo = new ProjectInfoDto(project);
    }
}
