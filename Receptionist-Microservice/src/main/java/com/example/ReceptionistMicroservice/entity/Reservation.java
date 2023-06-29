package com.example.ReceptionistMicroservice.entity;


import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Reservation")
public class Reservation {
    

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    @Min(1)
    private int roomNo;
    @NotNull

    private int children;
    @NotNull
    private int adults;
    @NotNull
    private String checkindate;
    @NotNull
    private String checkoutdate;
}
