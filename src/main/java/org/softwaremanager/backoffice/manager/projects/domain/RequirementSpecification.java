package org.softwaremanager.backoffice.manager.projects.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class RequirementSpecification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String goals;
    private String problemsToSolve;
    private String projectVision;
    private String risks;
}
