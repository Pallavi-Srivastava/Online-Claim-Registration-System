package com.blz.onlineclaimregistartion.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.blz.onlineclaimregistartion.model.Claim;

public interface IClaimRepository extends JpaRepository<Claim, Integer> {

}
