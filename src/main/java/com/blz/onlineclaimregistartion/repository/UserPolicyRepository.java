package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.UserPolicy;

@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {
	
	@Query(value = "SELECT *\r\n"
					+ "FROM user_policy AS up\r\n"
					+ "JOIN user_role AS ur\r\n"
					+ "ON up.fk_userid=ur.user_id AND up.fk_userid=:userId", nativeQuery = true)
	List<UserPolicy> findAllUserPoliciesByuserId(Long userId);
	
	@Query(value = "SELECT *\r\n"
					+ "	FROM user_policy AS up\r\n"
					+ "	JOIN user_role AS ur\r\n"
					+ "	ON up.fk_userid=ur.user_id AND ur.created_by =:userId", nativeQuery = true)
	List<UserPolicy> findAllUserPoliciesByRoleCodeAgent(Long userId);

}