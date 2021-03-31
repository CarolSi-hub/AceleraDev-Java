package com.challenge.endpoints;

import com.challenge.entity.Company;
import com.challenge.service.impl.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/company")
public class CompanyController {

  @Autowired
  private CompanyService service;

  @GetMapping("/{id}")
  Optional<Company> findById(@PathVariable Long id){
    return service.findById(id);
  }

  @GetMapping
  List<Company> findByAccelerationIdOrfindByUserId(
      @RequestParam(required = false) Long accelerationId,
      @RequestParam(required = false) Long userId){

    if(accelerationId != null) return service.findByAccelerationId(accelerationId);
    return service.findByUserId(userId);
  }
}
