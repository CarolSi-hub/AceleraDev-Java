package com.challenge.repository;

import com.challenge.entity.Challenge;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ChallengeRepository extends CrudRepository<Challenge, Long> {

  @Query(value = "SELECT * FROM challenge AS cha" +
      " INNER JOIN acceleration AS acc ON cha.id = acc.challenge_id" +
      " INNER JOIN candidate AS can ON can.acceleration_id = acc.id" +
      " INNER JOIN users AS usr ON can.user_id = usr.id" +
      " WHERE acc.id = :accelerationId AND usr.id = :userId"
      , nativeQuery = true)
  List<Challenge> findByAccelerationIdAndUserId(@Param("accelerationId") Long accelerationId,
                                                @Param("userId") Long userId);
}
