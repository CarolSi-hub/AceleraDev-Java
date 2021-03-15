package com.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class CandidateId implements Serializable {

  @ManyToOne
  private User user;

  @ManyToOne
  private Acceleration acceleration;

  @ManyToOne
  private Company company;
}
