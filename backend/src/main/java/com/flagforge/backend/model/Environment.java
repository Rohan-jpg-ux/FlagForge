package com.flagforge.backend.model;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity @Table(name="environment")
public class Environment {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(name="project_id") private Long projectId;
  private String name;
  @Column(name="sdk_key", unique=true) private String sdkKey;
  @Column(name="created_at") private OffsetDateTime createdAt = OffsetDateTime.now();

  public Long getId(){return id;}
  public Long getProjectId(){return projectId;}
  public void setProjectId(Long x){this.projectId=x;}
  public String getName(){return name;}
  public void setName(String n){this.name=n;}
  public String getSdkKey(){return sdkKey;}
  public void setSdkKey(String s){this.sdkKey=s;}
}