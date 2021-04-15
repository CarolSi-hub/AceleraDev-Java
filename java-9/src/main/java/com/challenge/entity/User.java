package com.challenge.entity;

import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.sql.Timestamp;
import java.util.List;

@EntityListeners(EntityListeners.class)
@Entity
@Table(name = "user")
public class User {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private int id;

  @Column
  @NotNull
  @Size(max=100)
  private String fullName;

  @Column
  @Email
  @NotNull
  @Size(max = 100)
  private String email;

  @Column
  @NotNull
  @Size(max = 50)
  private String nickname;

  @Column
  @NotNull
  @Size(max = 255)
  private String password;

  @Column
  @CreatedDate
  private Timestamp createdAt;

  @OneToMany
  private List<Candidate> candidate;

  @OneToMany
  private List<Submission> submission;
}
