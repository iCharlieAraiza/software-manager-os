package org.softwaremanager.backoffice.manager.projects.repository;

import org.softwaremanager.backoffice.manager.projects.domain.ProjectDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectDetailsRepository extends JpaRepository<ProjectDetails, Long > {
}
