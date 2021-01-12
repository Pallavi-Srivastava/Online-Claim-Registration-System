package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.blz.onlineclaimregistartion.model.Claim;

public interface IClaimRepository extends JpaRepository<Claim, Long> {

	@Query(value = "SELECT * \r\n"
					+ "FROM claim cl\r\n"
					+ "JOIN user_policy up\r\n"
					+ "ON  up.user_policy_id = cl.fk_user_policy_id AND up.fk_userid=:userId", nativeQuery = true)
	List<Claim> findAllClaimsByUserId(Long userId);

	@Query(value = "SELECT * \r\n"
					+ "FROM claim cl \r\n"
					+ "JOIN user_policy up \r\n"
					+ "ON  cl.fk_user_policy_id = up.user_policy_id \r\n"
					+ "JOIN user_role ur \r\n"
					+ "ON  ur.user_id = up.fk_userid AND ur.created_by=:userId", nativeQuery = true)
	List<Claim> findAllClaimsByRoleCodeAgent(Long userId);

}
