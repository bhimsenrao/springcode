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

	@PostMapping("/emp-address")
	public Employee createEmpAddress(@RequestBody EmpAddressRequest empAddressRequest) {
		return empAddressService.saveEmpAddress(empAddressRequest);
	}
	/*
	 * 
	 * { "employee": { "ename": "Ram babu", "email": "ram@example.com" }, "address":
	 * { "city": "Hyderabad", "state": "TS" } }
	 */

	@GetMapping("/employees/{empid}")
	public ResponseEntity<Employee> getEmployee(@PathVariable Integer empid) {
		Employee employee = empAddressService.getEmployee(empid);
		if (employee == null) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
		}
		return ResponseEntity.ok(employee);
	}

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
	
	@PutMapping("/employees/{empid}")
    public ResponseEntity<Employee> updateEmpAddress(
    		@PathVariable Integer empid, @RequestBody EmpAddressRequest empAddressRequest) {
        Employee updatedEmployee = empAddressService.updateEmpAddress(empid, empAddressRequest);
        return ResponseEntity.ok(updatedEmployee);
    }
	// query URL PUT: http://localhost:9900/employees/1
	/*
	 {
    "employee": {
        "ename": "Updated Name",
        "email": "updated.email@example.com"
    },
    "address": {
        "city": "Updated City",
        "state": "Updated State"
    }
} 
	 * */
	
}
