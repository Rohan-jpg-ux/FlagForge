package com.flagforge.backend.service;
import com.flagforge.backend.model.FeatureFlag;
import org.springframework.stereotype.Component;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.util.*;

@Component
public class Evaluator {
  public boolean evaluate(FeatureFlag flag, String userId) {
    if (flag == null || !flag.isEnabled()) return false;

    // allowlist short-circuit
    if (userId != null && flag.getAllowlist() != null) {
      List<String> allow = Arrays.stream(flag.getAllowlist().split(","))
        .map(String::trim).filter(s -> !s.isEmpty()).toList();
      if (allow.contains(userId)) return true;
    }

    // % rollout
    Integer pct = flag.getRolloutPercentage();
    if (pct == null) return true;
    int bucket = stableBucket(userId == null ? "anon" : userId, flag.getKey());
    return bucket < pct;
  }

  private int stableBucket(String userId, String salt) {
    try {
      MessageDigest md = MessageDigest.getInstance("MD5");
      byte[] h = md.digest((userId + "::" + salt).getBytes(StandardCharsets.UTF_8));
      int val = ((h[0] & 0xff) << 24) | ((h[1] & 0xff) << 16) | ((h[2] & 0xff) << 8) | (h[3] & 0xff);
      if (val < 0) val = -val;
      return val % 100;
    } catch (Exception e) { return 0; }
  }
}