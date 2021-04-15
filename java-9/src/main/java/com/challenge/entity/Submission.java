package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.sql.Timestamp;

@EntityListeners(EntityListeners.class)
@Entity
@Table(name = "submission")
public class Submission {

  @EmbeddedId
  private SubmissionId id;

  @Column
  @NotNull
  private Float score;

  @CreatedDate
  private Timestamp createdAt;
}
