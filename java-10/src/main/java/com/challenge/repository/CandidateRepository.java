package com.challenge.repository;

import com.challenge.entity.Candidate;
import com.challenge.entity.CandidateId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface CandidateRepository extends CrudRepository<Candidate, CandidateId> {

  @Query(value="SELECT * FROM candidate as can" +
      "WHERE can.id.user.id= :userId " +
      "AND can.id.company.id= :companyId " +
      "AND can.id.acceleration.id= :accelerationId",
      nativeQuery = true)
  Optional<Candidate> findById(@Param("userId") Long userId, @Param("companyId") Long companyId, @Param("accelerationId") Long accelerationId);

  @Query(value = "SELECT * FROM candidate AS can" +
      " INNER JOIN company AS com ON can.company_id = com.id" +
      " WHERE com.id = :id", nativeQuery = true)
  List<Candidate> findByCompanyId(@Param("id") Long companyId);

  @Query(value = "SELECT * FROM candidate AS can" +
      " INNER JOIN acceleration AS acc ON can.acceleration_id = acc.id" +
      " WHERE acc.id = :id", nativeQuery = true)
  List<Candidate> findByAccelerationId(@Param("id") Long accelerationId);
}
