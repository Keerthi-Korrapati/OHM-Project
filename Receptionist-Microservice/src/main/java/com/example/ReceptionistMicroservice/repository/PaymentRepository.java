package com.example.ReceptionistMicroservice.repository;

import com.example.ReceptionistMicroservice.entity.Payment;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {
}
