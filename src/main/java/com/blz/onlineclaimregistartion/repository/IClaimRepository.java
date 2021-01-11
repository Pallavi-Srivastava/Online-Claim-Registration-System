package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blz.onlineclaimregistartion.model.Claim;

public interface IClaimRepository extends JpaRepository<Claim, Long> {

//	@Query(value = "SELECT * FROM claim where policy_id_fk=:policyId", nativeQuery = true)
//	List<Claim> findClaimById(long policyId);
}
