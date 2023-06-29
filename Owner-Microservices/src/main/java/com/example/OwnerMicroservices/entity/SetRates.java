package com.example.OwnerMicroservices.entity;

import lombok.AllArgsConstructor;  
import lombok.Builder;
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
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder()
@Entity
@Table(name="Rates")
//@Document(collection = "SetRates")
public class SetRates {

  
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @NotNull
    @Min(1)
    private  int guest;
    @NotNull
    @Min(1)
    private int days;
    @NotNull
    @Min(1)
    private int nightPrice;
    @NotNull
    private int extension;

}
