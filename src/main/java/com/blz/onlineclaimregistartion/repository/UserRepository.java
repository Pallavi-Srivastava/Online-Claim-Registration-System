package com.blz.onlineclaimregistartion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{

	@Query(value = "select * from user_role where user_name=:userName",nativeQuery = true)
	User findByName(String userName);

}
