package org.softwaremanager.backoffice.manager.projects.repository;

import org.softwaremanager.backoffice.manager.projects.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProjectRepository extends JpaRepository<Project,Long> {
}
