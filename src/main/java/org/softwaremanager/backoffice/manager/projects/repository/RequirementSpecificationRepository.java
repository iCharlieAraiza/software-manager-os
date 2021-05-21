package org.softwaremanager.backoffice.manager.projects.repository;

import org.softwaremanager.backoffice.manager.projects.domain.RequirementSpecification;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequirementSpecificationRepository extends JpaRepository<RequirementSpecification, Double> {
}
