package org.softwaremanager.backoffice.manager.projects.domain;

import lombok.Data;

import javax.persistence.Id;

@Data
public class RequirementSpecification {
    @Id
    private Long id;
    private String goals;
    private String problemsToSolve;
    private String projectVision;
    private String risks;
}
