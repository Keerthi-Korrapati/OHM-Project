package com.example.ReceptionistMicroservice.repository;

import com.example.ReceptionistMicroservice.entity.Guest;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GuestRepository extends JpaRepository<Guest,Integer> {
}
