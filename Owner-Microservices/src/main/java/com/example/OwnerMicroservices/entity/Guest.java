package com.example.OwnerMicroservices.entity;

import lombok.AllArgsConstructor;

import lombok.Data;
import lombok.NoArgsConstructor;
//import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
///import org.springframework.data.mongodb.core.mapping.Document;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

//@Document(collection = "Guest")
public class Guest  {
    
    @Id
    private int id;
    @NotNull
    @Size(min = 2, message = " Name should have atleast 2 characters")
    private String name;
    @NotNull
    @Min(1)
    private int roomNo;
    @NotNull
    @Min(9)
    private Long phoneNo;
    @Email
    @NotBlank
    private String email;
    @NotNull
    private String gender;
    @NotNull
    @Size(min = 2, message = " Name should have atleast 2 characters")
    private String address;

}
