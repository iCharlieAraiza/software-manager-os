package org.softwaremanager.backoffice.manager.bugtracker.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Data
public class Type {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String description;

    public Type(){}

    public Type(String name, String description) {
        this.name = name;
        this.description = description;
    }
}
