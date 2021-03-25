package com.challenge.service.implementation;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import com.challenge.repository.CandidateRepository;
import com.challenge.service.interfaces.CandidateServiceInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CandidateServiceImpl implements CandidateServiceInterface {

  @Autowired
  private CandidateRepository repository;

  @Override
  public Optional<Candidate> findById(CandidateId id) {
    return repository.findById(id);
  }

  @Override
  public Optional<Candidate> findById(Long userId, Long companyId, Long accelerationId) {
    return repository.findById(userId, companyId, accelerationId);
  }

  @Override
  public List<Candidate> findByCompanyId(Long companyId) {
    return repository.findByCompanyId(companyId);
  }

  @Override
  public List<Candidate> findByAccelerationId(Long accelerationId) {
    return repository.findByAccelerationId(accelerationId);
  }

  @Override
  public Candidate save(Candidate object) {
    return repository.save(object);
  }
}
