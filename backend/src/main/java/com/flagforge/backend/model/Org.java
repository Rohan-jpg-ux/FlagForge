package com.flagforge.backend.model;
import jakarta.persistence.*;
import java.time.OffsetDateTime;

@Entity @Table(name="org")
public class Org {
  @Id @GeneratedValue(strategy=GenerationType.IDENTITY) private Long id;
  private String name;
  @Column(name="created_at") private OffsetDateTime createdAt = OffsetDateTime.now();
  public Long getId(){return id;}
  public String getName(){return name;}
  public void setName(String n){this.name=n;}
}