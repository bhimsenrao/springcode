package com.onetoone.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.onetoone.entity.EmpAddressRequest;
import com.onetoone.entity.Employee;
import com.onetoone.service.EmpAddressService;

@RestController
//@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmpAddressService empAddressService;

    @PostMapping("/")
//    public ResponseEntity<String> addEmployeeAndAddress(@RequestBody EmpAddressRequest request) {
//        empAddressService.addEmployeeAndAddress(request.getEmployee(), request.getAddress());
//        return new ResponseEntity<>("Employee and address saved successfully", HttpStatus.OK);
//    }
    public ResponseEntity<Employee> addEmployeeAndAddress(@RequestBody EmpAddressRequest request) {
        empAddressService.addEmployeeAndAddress(request.getEmployee(), request.getAddress());
        return new ResponseEntity<Employee>(request.getEmployee(), HttpStatus.OK);
    }
    /*
     * for adding record
     * method POST:url-->http://localhost:9900/
      {
        "employee": {
            "ename": "Janardhan",
            "mailId": "jana@example.com"
        },
        "address": {
            "city": "New York",
            "state": "NY"
        }
    }
  * */
     
    
    @GetMapping("/city/{city}")
    java.util.List<Employee> getEmployeesByCity(@PathVariable("city") String city) { 
    	return empAddressService.getEmployeesByCity(city);
    }
    // query URL GET: http://localhost:9900/city/Warangal
    @GetMapping("/count/{city}")
    Integer getCount(@PathVariable("city") String city) { 
    	return empAddressService.countOfEmployeesInCity(city);
    }
    // query URL GET: http://localhost:9900/count/Warangal
}

