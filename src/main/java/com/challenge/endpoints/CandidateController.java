package com.challenge.endpoints;

import com.challenge.entity.Candidate;
import com.challenge.service.impl.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/candidate")
public class CandidateController {

  @Autowired
  private CandidateService service;

  @GetMapping("/{userId}/{accelerationId}/{companyId}")
  Optional<Candidate> findById(@PathVariable Long userId,
                               @PathVariable Long companyId,
                               @PathVariable Long accelerationId){
    return service.findById(userId, companyId, accelerationId);
  }

  @GetMapping
  List<Candidate> findByCompanyIdOrByAccelerationId(
      @RequestParam(required = false) Long accelerationId,
      @RequestParam(required = false) Long companyId){

    if(accelerationId != null) return service.findByAccelerationId(accelerationId);
    return service.findByCompanyId(companyId);
  }
}
