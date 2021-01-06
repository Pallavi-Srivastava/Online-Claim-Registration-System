package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

	@Query(value = "SELECT * FROM policy_details WHERE user_id_fk=:userId", nativeQuery = true)
	List<Policy> getAllPoliciesRegisteredByUserId(Long userId);

	@Query(value = "SELECT * FROM policy_details WHERE policy_number=:policyNumber AND user_id_fk=:userId", nativeQuery = true)
	Policy findPolicyId(long policyNumber, long userId);

	@Query(value = "SELECT * FROM policy_details WHERE policy_number=:policyNumber AND user_id_fk is null", nativeQuery = true)
	Policy findPolicyDetails(long policyNumber);

}
