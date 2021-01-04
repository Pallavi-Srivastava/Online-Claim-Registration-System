package com.blz.onlineclaimregistartion.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.blz.onlineclaimregistartion.model.Policy;

@Repository
public interface PolicyRepository extends JpaRepository<Policy, Long> {

}
