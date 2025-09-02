package com.flagforge.backend.repo;

import com.flagforge.backend.model.FeatureFlag;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface FeatureFlagRepo extends JpaRepository<FeatureFlag, Long> {
    Optional<FeatureFlag> findByProjectIdAndKey(Long projectId, String key);
}
