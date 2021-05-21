package org.softwaremanager.backoffice.manager.projects.domain.dto;

import lombok.Data;
import org.modelmapper.ModelMapper;
import org.softwaremanager.backoffice.auth.web.dto.UserInfoDto;
import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;
import org.softwaremanager.backoffice.manager.projects.domain.Status;

import java.util.Date;

@Data
public class ProjectInfoDto {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Status status;
    private ProjectDetails projectDetails;
    private UserInfoDto userInfo;

    public ProjectInfoDto(){}

    public ProjectInfoDto(Project project){
        ModelMapper modelMapper = new ModelMapper();
        ProjectInfoDto dto = modelMapper.map(project, ProjectInfoDto.class);

        this.id = dto.getId();
        this.name = dto.getName();
        this.description = dto.getDescription();
        this.startDate = dto.getStartDate();
        this.endDate = dto.getEndDate();
        this.status = dto.getStatus();
        this.projectDetails = dto.getProjectDetails();
        this.userInfo = dto.getUserInfo();
    }

    public Project toProject(){
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(this, Project.class);
    }
}
