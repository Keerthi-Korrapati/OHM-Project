package com.example.MangerMicroservice.entity;

import javax.persistence.Id;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

public class Payment {
    

    @Id
    private int id;
    private int roomNo;
    private Long creditcard;
    private int total;
    private String paytime;


}
