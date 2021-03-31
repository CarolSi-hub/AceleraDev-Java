package com.challenge.endpoints;

import com.challenge.entity.User;
import com.challenge.service.impl.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserService service;

  @GetMapping("/{id}")
  public Optional<User> findById(@PathVariable Long id) {
    return service.findById(id);
  }

  @GetMapping
  public List<User> findByAccelerationNameOrCompanyId(@RequestParam(required = false) String accelerationName,
  @RequestParam(required = false) Long companyId){
    if (accelerationName != null) return service.findByAccelerationName(accelerationName);
    return service.findByCompanyId(companyId);
  };

}
