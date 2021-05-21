package org.softwaremanager.backoffice.manager.projects.domain.dto;

import lombok.Data;
import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;

import java.util.List;

@Data
public class ProjectDto {
    private ProjectInfoDto projectInfoDto;
    private List<String> emails;
    private ProjectDetails projectDetails;
}
