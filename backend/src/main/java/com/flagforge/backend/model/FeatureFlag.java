package com.flagforge.backend.model;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity @Table(name="feature_flag")
public class FeatureFlag {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(name="project_id") private Long projectId;
  @Column(name="key") private String key;
  private String description;
  private boolean enabled;
  @Column(name="rollout_percentage") private Integer rolloutPercentage; // 0..100
  private String allowlist; // comma-separated user IDs
  @Column(name="created_at") private OffsetDateTime createdAt = OffsetDateTime.now();

  public Long getId(){return id;}
  public Long getProjectId(){return projectId;}
  public void setProjectId(Long x){this.projectId=x;}
  public String getKey(){return key;}
  public void setKey(String k){this.key=k;}
  public String getDescription(){return description;}
  public void setDescription(String d){this.description=d;}
  public boolean isEnabled(){return enabled;}
  public void setEnabled(boolean e){this.enabled=e;}
  public Integer getRolloutPercentage(){return rolloutPercentage;}
  public void setRolloutPercentage(Integer p){this.rolloutPercentage=p;}
  public String getAllowlist(){return allowlist;}
  public void setAllowlist(String a){this.allowlist=a;}
}