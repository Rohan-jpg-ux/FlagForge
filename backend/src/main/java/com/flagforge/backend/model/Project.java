package com.flagforge.backend.model;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity @Table(name="project")
public class Project{
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  @Column(name="org_id") private Long orgId;
  private String name;
  @Column(name="created_at") private OffsetDateTime createdAt = OffsetDateTime.now();
  public Long getId(){return id;}
  public Long getOrgId(){return orgId;}
  public void setOrgId(Long x){this.orgId=x;}
  public String getName(){return name;}
  public void setName(String n){this.name=n;}
}