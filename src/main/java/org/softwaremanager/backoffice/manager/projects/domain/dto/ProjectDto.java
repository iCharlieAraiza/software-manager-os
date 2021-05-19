package org.softwaremanager.backoffice.manager.projects.domain.dto;

import lombok.Data;
import org.softwaremanager.backoffice.auth.web.dto.UserInfoDto;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;
import org.softwaremanager.backoffice.manager.projects.domain.Status;

import java.util.Date;

@Data
public class ProjectDto {
    private Long id;
    private String name;
    private String description;
    private Date startDate;
    private Date endDate;
    private Status status;
    private ProjectDetails projectDetails;
    private UserInfoDto userInfo;
}