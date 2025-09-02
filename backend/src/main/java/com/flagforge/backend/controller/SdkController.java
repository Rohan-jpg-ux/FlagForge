package com.flagforge.backend.controller;

import com.flagforge.backend.dto.Dto.EvalResponse;
import com.flagforge.backend.model.Environment;
import com.flagforge.backend.model.FeatureFlag;
import com.flagforge.backend.repo.EnvironmentRepo;
import com.flagforge.backend.repo.FeatureFlagRepo;
import com.flagforge.backend.service.Evaluator;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/sdk/v1")
@CrossOrigin(origins = "*")
public class SdkController {
    private final EnvironmentRepo environmentRepo;
    private final FeatureFlagRepo featureFlagRepo;
    private final Evaluator evaluator;

    public SdkController(EnvironmentRepo environmentRepo, FeatureFlagRepo featureFlagRepo, Evaluator evaluator) {
        this.environmentRepo = environmentRepo;
        this.featureFlagRepo = featureFlagRepo;
        this.evaluator = evaluator;
    }
    @GetMapping("/evaluate")
    public ResponseEntity<EvalResponse> evaluate(
            @RequestParam String sdkKey,
            @RequestParam String flagKey,
            @RequestParam String userId
    ) {
        Environment environment = environmentRepo.findBySdkKey(sdkKey)
                .orElseThrow(() -> new RuntimeException("Invalid SDK Key"));

        FeatureFlag featureFlag = featureFlagRepo.findByProjectIdAndKey(environment.getProjectId(), flagKey)
                .orElseThrow(() -> new RuntimeException("Feature flag not found"));

        boolean value = evaluator.evaluate(featureFlag, userId);

        EvalResponse response = new EvalResponse(flagKey, value);
        return ResponseEntity.ok(response);
    }
}