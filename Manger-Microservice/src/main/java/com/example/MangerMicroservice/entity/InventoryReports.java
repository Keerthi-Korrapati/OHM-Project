package com.example.MangerMicroservice.entity;


import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "InventoryReports")
public class InventoryReports {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotNull
    private Long totalincome;
    @NotNull
    private Long maintainanceCost;
    @NotNull
    private Long employeesalary;
    @NotNull
    private Long totalProfit;


}
