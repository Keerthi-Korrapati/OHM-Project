package com.example.ReceptionistMicroservice.repository;

import com.example.ReceptionistMicroservice.entity.Reservation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReservationRepository extends JpaRepository<Reservation,Integer> {
    Boolean existsByroomNo(int roomNo);
}
