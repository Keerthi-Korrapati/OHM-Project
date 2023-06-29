package com.example.ReceptionistMicroservice.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Payment")
public class Payment {
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;


    private int roomNo;

    private Long creditcard;

    private int total;


    private String paytime;


}
