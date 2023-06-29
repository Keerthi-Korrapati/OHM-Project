package com.example.ReceptionistMicroservice.repository;

import com.example.ReceptionistMicroservice.entity.IssueBills;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface IssueBillRepository extends JpaRepository<IssueBills,Integer> {
}
