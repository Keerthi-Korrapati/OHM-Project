package com.example.MangerMicroservice.repository;



import com.example.MangerMicroservice.entity.Employee;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository  extends JpaRepository<Employee,Integer> {

}
