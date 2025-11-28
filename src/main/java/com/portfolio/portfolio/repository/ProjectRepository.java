package com.portfolio.portfolio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.portfolio.portfolio.model.Project;

public interface ProjectRepository extends JpaRepository<Project, Long> {

}
