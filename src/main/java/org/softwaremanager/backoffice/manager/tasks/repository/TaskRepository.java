package org.softwaremanager.backoffice.manager.tasks.repository;

import org.softwaremanager.backoffice.manager.tasks.domain.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {
}
