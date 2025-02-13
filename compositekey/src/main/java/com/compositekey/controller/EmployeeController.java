package com.compositekey.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.compositekey.entity.Employee;
import com.compositekey.entity.EmployeeIdentity;
import com.compositekey.service.EmployeeService;
import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<Employee> create(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.save(employee);
        return ResponseEntity.ok(savedEmployee);
    }

    @GetMapping("/{employeeId}/{companyId}")
    public ResponseEntity<Employee> getById(@PathVariable String employeeId, @PathVariable String companyId) {
        EmployeeIdentity id = new EmployeeIdentity(employeeId, companyId);
        Employee employee = employeeService.findById(id);
        return ResponseEntity.ok(employee);
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAll() {
        List<Employee> employees = employeeService.findAll();
        return ResponseEntity.ok(employees);
    }

    @DeleteMapping("/{employeeId}/{companyId}")
    public ResponseEntity<Void> deleteById(@PathVariable String employeeId, @PathVariable String companyId) {
        EmployeeIdentity id = new EmployeeIdentity(employeeId, companyId);
        employeeService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
    
    @GetMapping("/company/{companyId}") 
    public ResponseEntity<List<Employee>> getByCompanyId(@PathVariable String companyId) {
     List<Employee> employees = employeeService.findByCompanyId(companyId); 
    return ResponseEntity.ok(employees); 
    }

}
/*
 * For PostMan
 * POST method:
  {
    "employeeIdentity": {
        "employeeId": "E123",
        "companyId": "C456"
    },
    "name": "John Doe",
    "email": "john.doe@example.com",
    "phoneNumber": "123-456-7890"
}

 * GET method:
 * for single record
 * http://localhost:8080/api/employees/E123/C456  
 *
 * for all records
 * http://localhost:9900/api/employees
   for a particular company id
   http://localhost:8080/api/employees/company/C456 
 PUT method:
 http://localhost:8080/api/employees
 
 {
    "employeeIdentity": {
        "employeeId": "E123",
        "companyId": "C456"
    },
    "name": "Jane Doe",
    "email": "jane.doe@example.com",
    "phoneNumber": "987-654-3210"
}

 * 
 *DELETE method:
 *http://localhost:8080/api/employees/E123/C456
 * 
 * */
