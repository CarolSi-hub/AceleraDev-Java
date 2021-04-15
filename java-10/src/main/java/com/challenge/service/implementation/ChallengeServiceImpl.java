package com.challenge.service.implementation;

import com.challenge.entity.Challenge;
import com.challenge.repository.ChallengeRepository;
import com.challenge.service.interfaces.ChallengeServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ChallengeServiceImpl implements ChallengeServiceInterface {

  @Autowired
  private ChallengeRepository repository;

  @Override
  public List<Challenge> findByAccelerationIdAndUserId(Long accelerationId, Long userId) {
    return repository.findByAccelerationIdAndUserId(accelerationId, userId);
  }

  @Override
  public Challenge save(Challenge object) {
    return repository.save(object);
  }
}
