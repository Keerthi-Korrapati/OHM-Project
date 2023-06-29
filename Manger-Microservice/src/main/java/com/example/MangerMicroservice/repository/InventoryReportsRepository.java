package com.example.MangerMicroservice.repository;



import com.example.MangerMicroservice.entity.InventoryReports;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;

@Repository
public interface InventoryReportsRepository extends JpaRepository<InventoryReports,Integer> {

}
