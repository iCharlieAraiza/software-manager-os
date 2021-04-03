package org.softwaremanager.backoffice.manager.bugtracker.domain;

import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;

public class Bug {
    private Long id;
    @OneToMany
    @JoinColumn(name="type_id")
    private Type type;
}
