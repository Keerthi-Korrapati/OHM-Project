package com.example.OwnerMicroservices.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.OwnerMicroservices.entity.SetRates; 
//import org.springframework.data.mongodb.repository.MongoRepository;

public interface SetRatesRepository  extends JpaRepository<SetRates,Integer> {
}
