package com.onetoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetoone.entity.Address;
import com.onetoone.entity.EmpAddressRequest;
import com.onetoone.entity.Employee;
import com.onetoone.exception.RecordNotFoundException;
import com.onetoone.repo.AddressRepository;
import com.onetoone.repo.EmployeeRepository;

@Service
public class EmpAddressService {
	 @Autowired
	    private EmployeeRepository employeeRepo;

	    public Employee saveEmpAddress(EmpAddressRequest empAddressRequest) {
	        Employee employee = empAddressRequest.getEmployee();
	        Address address = empAddressRequest.getAddress();

	        if (address != null) {
	            address.setEmployee(employee);
	            employee.setAddress(address);
	        }
	        return employeeRepo.save(employee);
	    }

	    public Employee getEmployee(Integer empid) {
	        return employeeRepo.findById(empid).orElseThrow(()-> new RuntimeException("Employee record DNE with id:"+empid));
	    }
	
    public java.util.List<Employee> getEmployeesByCity(String city) { 
    	return employeeRepo.findEmployeesByCity(city);
    }
    
    public Integer countOfEmployeesInCity(String city) {
    	return employeeRepo.findEmployeeByCity(city);
    }
    
    public Employee updateEmpAddress(Integer empid, EmpAddressRequest empAddressRequest) {
        Employee existingEmployee = employeeRepo.findById(empid)
            .orElseThrow(() -> new RecordNotFoundException("Employee not found with id=" + empid));

        Employee updatedEmployee = empAddressRequest.getEmployee();
        Address updatedAddress = empAddressRequest.getAddress();

        if (updatedEmployee != null) {
            existingEmployee.setEname(updatedEmployee.getEname());
            existingEmployee.setEmail(updatedEmployee.getEmail());
        }

        if (updatedAddress != null) {
            Address existingAddress = existingEmployee.getAddress();
            existingAddress.setCity(updatedAddress.getCity());
            existingAddress.setState(updatedAddress.getState());
        }

        return employeeRepo.save(existingEmployee);
    }
    
    
}
