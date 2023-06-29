package com.example.ReceptionistMicroservice.entity;


import com.example.ReceptionistMicroservice.validation.ValidateIsOccupied; 
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "Room")
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private int roomNo;
    @NotNull
    @Size(min = 1, message = " Room should have atleast 1 Number")
    private String roomType;
    //custom annotation
    @ValidateIsOccupied(message = "isocuppied must be Avaliable or Booked!")
    private String isOccupied;
    @NotNull
    @Min(1)
    private int roomCost;
    private String checkIn;
    private String checkOut;

}