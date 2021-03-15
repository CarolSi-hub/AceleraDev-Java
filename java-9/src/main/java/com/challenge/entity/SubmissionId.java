package com.challenge.entity;

import javax.persistence.*;
import java.io.Serializable;

@Embeddable
public class SubmissionId implements Serializable {

  @ManyToOne
  private Challenge challenge;

  @ManyToOne
  private User user;
}
