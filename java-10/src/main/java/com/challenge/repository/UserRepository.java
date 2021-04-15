package com.challenge.repository;

import com.challenge.entity.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface UserRepository extends CrudRepository<User, Long> {

  @Query(value = "SELECT * FROM users AS usr" +
      " INNER JOIN candidate AS can ON usr.id = can.user_id" +
      " INNER JOIN acceleration AS acc ON can.acceleration_id = acc.id" +
      " WHERE acc.name LIKE %:name%",
      nativeQuery = true)
  List<User> findByAccelerationName(@Param("name") String name);

  @Query(value = "SELECT * FROM users AS usr" +
      " INNER JOIN candidate AS can ON usr.id = can.user_id" +
      " INNER JOIN company AS com ON com.id = can.company_id" +
      " WHERE com.id = :id",
      nativeQuery = true)
  List<User> findByCompanyId(@Param("id") Long companyId);
}
