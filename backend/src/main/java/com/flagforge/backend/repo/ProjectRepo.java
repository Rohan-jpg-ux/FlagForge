package com.flagforge.backend.repo;

import com.flagforge.backend.model.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project, Long> { }
