package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@EntityListeners(EntityListeners.class)
@Entity
@Table(name = "acceleration")
public class Acceleration{

  @Id
  @GeneratedValue(strategy = GenerationType.SEQUENCE)
  private int id;

  @Column
  @NotNull
  @Size(max=100)
  private String name;

  @Column
  @NotNull
  @Size(max=50)
  private String slug;

  @Column
  @CreatedDate
  private Timestamp createdAt;

  @ManyToOne
  private Challenge challenge;

  @OneToMany(mappedBy = "id.acceleration")
  private List<Candidate> candidates;

}
