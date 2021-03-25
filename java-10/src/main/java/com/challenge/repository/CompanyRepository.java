package com.challenge.repository;

import com.challenge.entity.Company;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CompanyRepository extends CrudRepository<Company, Long> {

  @Query(value = "SELECT * FROM company AS com" +
      " INNER JOIN candidate AS can ON can.company_id = com.id" +
      " INNER JOIN acceleration AS acc ON can.acceleration_id = acc.id" +
      " WHERE acc.id = :id LIMIT 1", nativeQuery = true)
  List<Company> findByAccelerationId(@Param("id") Long accelerationId);

  @Query(value = "SELECT * FROM company AS com" +
      " INNER JOIN candidate AS can ON can.company_id = com.id" +
      " INNER JOIN users AS usr ON can.user_id = usr.id" +
      " WHERE usr.id = :id", nativeQuery = true)
  List<Company> findByUserId(@Param("id") Long userId);

}


