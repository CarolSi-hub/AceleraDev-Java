package com.challenge.repository;

import com.challenge.entity.Submission;
import com.challenge.entity.SubmissionId;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.math.BigDecimal;
import java.util.List;

public interface SubmissionRepository extends CrudRepository<Submission, SubmissionId> {

  @Query(value = "SELECT MAX(sub.score) AS MaxScore FROM submission AS sub" +
      " INNER JOIN challenge AS cha ON cha.id = sub.challenge_id" +
      " WHERE cha.id = :id",
      nativeQuery = true)
  BigDecimal findHigherScoreByChallengeId(@Param("id") Long id);

  @Query(value = "SELECT * FROM submission AS sub" +
      " INNER JOIN challenge AS cha ON sub.challenge_id = cha.id" +
      " INNER JOIN acceleration AS acc ON acc.challenge_id = cha.id" +
      " WHERE cha.id = :challengeId AND acc.id = :accelerationId ",
      nativeQuery = true)
  List<Submission> findByChallengeIdAndAccelerationId(@Param("challengeId") Long challengeId,
                                                      @Param("accelerationId") Long accelerationId );;

}
