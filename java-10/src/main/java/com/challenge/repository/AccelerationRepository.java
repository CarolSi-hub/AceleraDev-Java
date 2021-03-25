package com.challenge.repository;

import com.challenge.entity.Acceleration;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AccelerationRepository extends CrudRepository<Acceleration, Long> {

  @Query(value = "SELECT * FROM acceleration AS acc" +
      " INNER JOIN candidate AS can ON can.acceleration_id = acc.id" +
      " INNER JOIN company AS com ON com.id = can.company_id" +
      " WHERE com.id = :id",
      nativeQuery = true)
  List<Acceleration> findByCompanyId(@Param("id") Long companyId);

}
