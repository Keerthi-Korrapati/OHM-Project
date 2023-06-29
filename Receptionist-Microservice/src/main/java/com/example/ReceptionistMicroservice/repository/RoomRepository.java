package com.example.ReceptionistMicroservice.repository;

import com.example.ReceptionistMicroservice.entity.Room; 

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.stereotype.Repository;



@Repository
public interface RoomRepository extends JpaRepository<Room,Integer> {
    Boolean existsByroomNo(int roomNo);



}
