package org.softwaremanager.backoffice.manager.projects.service;

import org.softwaremanager.backoffice.manager.projects.domain.dto.ProjectInfoDto;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProjectService{
    List<ProjectInfoDto> findAll(Pageable pageable);
}
