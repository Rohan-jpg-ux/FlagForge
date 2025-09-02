package com.flagforge.backend.repo;

import com.flagforge.backend.model.Environment;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface EnvironmentRepo extends JpaRepository<Environment, Long> {
    Optional<Environment> findBySdkKey(String sdkKey);
}