package com.example.MangerMicroservice.Controller;


import com.example.MangerMicroservice.entity.Employee; 
import com.example.MangerMicroservice.exception.ResourceNotFoundException;
import com.example.MangerMicroservice.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@CrossOrigin("*")
@RestController
@RequestMapping("/Manager")
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;


    //get Employeelist
    @GetMapping("/employee/list")
    public List<Employee> getAllEmployee(){
        return  this.employeeRepository.findAll();
    }

    //Get employee by id
    @GetMapping("/employee/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable(value = "id") int  employeeId)
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " +employeeId ));
        return ResponseEntity.ok().body(employee);
    }


    //save Employee
    @PostMapping("/employee/save")
    public Employee createEmployee(@Valid @RequestBody Employee employee){
        return  this.employeeRepository.save(employee);
    }

    //edit employee
    @PutMapping("employee/edit/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable(value = "id") int  employeeId,
                                                   @Validated @RequestBody Employee employeeDetails  )
            throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(employeeId)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not found for this id :: " +employeeId ));
        employee.setEmpName(employeeDetails.getEmpName());
        employee.setEmpAddress(employeeDetails.getEmpAddress());
        employee.setSalary(employeeDetails.getSalary());
        employee.setOccupation(employeeDetails.getOccupation());
        employee.setEmail(employeeDetails.getEmail());
        return ResponseEntity.ok(this.employeeRepository.save(employee));
    }


    @DeleteMapping("employee/delete/{id}")

    public ResponseEntity<Map<String, Boolean>> deleteEmployee(@PathVariable int id) throws ResourceNotFoundException {
        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee not exist with id :" + id));

        employeeRepository.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return ResponseEntity.ok(response);


    }


}
