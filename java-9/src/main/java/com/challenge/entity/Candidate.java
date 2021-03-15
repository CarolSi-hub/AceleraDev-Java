package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.sql.Timestamp;

@EntityListeners(EntityListeners.class)
@Entity
@Table(name = "candidate")
public class Candidate implements Serializable {

  @EmbeddedId
  private CandidateId id;

  @Column
  @NotNull
  private Integer status;

  @Column
  @CreatedDate
  private Timestamp createdAt;

}
