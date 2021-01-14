package com.blz.onlineclaimregistartion.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.Claim;
import com.blz.onlineclaimregistartion.model.UserPolicy;

@Repository
public interface UserPolicyRepository extends JpaRepository<UserPolicy, Long> {

//	@Query(value = "SELECT up.user_policy_id, pd.policy_name, pd.policy_id, pd.premium \r\n"
//			+ "FROM policy_details as pd\r\n"
//			+ "INNER JOIN user_policy as up\r\n"
//			+ "WHERE up.fk_userid=:userId and pd.policy_id = up.fk_policy_id;", nativeQuery = true)
//	List<Object> findAllByuserId(Long userId);
	
	
	@Query(value = "SELECT up.user_policy_id, pd.policy_name, pd.policy_id, pd.premium, ur.account_number \r\n"
					+ "FROM policy_details AS pd\r\n"
					+ "JOIN user_policy AS up\r\n"
					+ "ON pd.policy_id = up.fk_policy_id\r\n"
					+ "JOIN user_role AS ur \r\n"
					+ "WHERE up.fk_userid=ur.user_id AND up.fk_userid=:userId", nativeQuery = true)
	List<String> findAllUserPoliciesByuserId(Long userId);

	@Query(value = "SELECT up.user_policy_id, pd.policy_name,  pd.policy_id, pd.premium, ur.account_number\r\n"
					+ "FROM policy_details pd \r\n"
					+ "JOIN user_role ur \r\n"
					+ "ON ur.created_by =:userId \r\n"
					+ "JOIN user_policy up\r\n"
					+ "WHERE up.fk_userid = ur.user_id  AND up.fk_policy_id = pd.policy_id;", nativeQuery = true)
	List<String> findAllUserPoliciesByRoleCodeAgent(Long userId);

	@Query(value = "SELECT up.user_policy_id, pd.policy_name, pd.policy_id, pd.premium, ur.account_number\r\n"
					+ "FROM policy_details as pd \r\n"
					+ "LEFT JOIN user_policy as up \r\n"
					+ "ON up.fk_policy_id = policy_id \r\n"
					+ "JOIN user_role AS ur \r\n"
					+ "ON up.fk_userid=ur.user_id", nativeQuery = true)
	List<String> findAllUserPoliciesByAdmin();

}
