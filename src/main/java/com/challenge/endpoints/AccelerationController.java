package com.challenge.endpoints;

import com.challenge.entity.Acceleration;
import com.challenge.service.impl.AccelerationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/acceleration")
public class AccelerationController {

  @Autowired
  private AccelerationService service;

  @GetMapping("/{id}")
  Optional<Acceleration> findById(@PathVariable Long id){
    return service.findById(id);
  }

  @GetMapping
  List<Acceleration> findByCompanyId(@RequestParam Long companyId){
    return service.findByCompanyId(companyId);
  }
}
