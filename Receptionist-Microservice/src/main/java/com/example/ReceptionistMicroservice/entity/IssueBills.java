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
@Table(name = "IssueBills")
public class IssueBills {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int billNo;

    private int roomNo;

    private int price;

    private int taxes;

    private  String date;

    private int service;

    private int total;
}
