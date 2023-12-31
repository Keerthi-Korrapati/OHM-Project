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
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Data
@AllArgsConstructor
@NoArgsConstructor
//@Document(collection = "Employee")
public class Employee {

    @Id
    private int id;
    @NotNull
    @Size(min = 2, message = " Name should have atleast 2 characters")
    private String empName;
    @NotNull
    private String empAddress;
    @NotNull
    private int salary;

    @NotNull
    @Size(min = 2, message = " Occuption should have atleast 2 characters")
    private String occupation;
    @Email
    @NotBlank
    private String email;

   }