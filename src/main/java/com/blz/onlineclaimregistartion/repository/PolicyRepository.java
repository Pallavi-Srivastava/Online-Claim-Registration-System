package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

	@Query(value = "SELECT * FROM policy_details INNER JOIN user_policies AS up WHERE up.user_id = :userId", nativeQuery = true)
	List<Policy> getAllPoliciesRegisteredByUserId(Long userId);

//	@Query(value = "SELECT * FROM policy_details INNER JOIN user_policies AS up WHERE up.user_id = :userId", nativeQuery = true)
//	Policy registerPolicyByUserId(Long userId, Long policyId);

}
