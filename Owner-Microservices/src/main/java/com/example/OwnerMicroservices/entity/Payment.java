package com.example.OwnerMicroservices.entity;

import lombok.AllArgsConstructor; 
import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.annotation.Transient;
//import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Payment {
    

    @Id
    private int id;
    @NotNull
    @Size(min = 1, message = " Occuption should have atleast 1 characters")
    private int roomNo;
    @NotNull
    @Size(min = 12, message = " Occuption should have atleast 12 characters")
    private Long creditcard;
    @NotNull
    @Size(min = 1, message = " Occuption should have atleast 1 characters")
    private int total;
    @NotNull

    private String paytime;


}
