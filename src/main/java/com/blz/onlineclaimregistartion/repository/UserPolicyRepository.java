package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.UserPolicy;

@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {

//	@Query(value = "SELECT up.user_policy_id, pd.policy_name, pd.policy_id, pd.premium \r\n"
//			+ "FROM policy_details as pd\r\n"
//			+ "INNER JOIN user_policy as up\r\n"
//			+ "WHERE up.fk_userid=:userId and pd.policy_id = up.fk_policy_id;", nativeQuery = true)
//	List<Object> findAllByuserId(Long userId);
	
	
	@Query(value = "SELECT up.user_policy_id, pd.policy_name, pd.policy_id, pd.premium \r\n"
			+ "FROM policy_details as pd\r\n"
			+ "INNER JOIN user_policy as up\r\n"
			+ "WHERE up.fk_userid=:userId and pd.policy_id = up.fk_policy_id;", nativeQuery = true)
	List<String> findAllByuserId(Long userId);
}
