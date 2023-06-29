package com.example.OwnerMicroservices.entity;


import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryReports {

    
    @Id
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