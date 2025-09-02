package com.flagforge.backend.repo;

import com.flagforge.backend.model.Org;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrgRepo extends JpaRepository<Org, Long> { }