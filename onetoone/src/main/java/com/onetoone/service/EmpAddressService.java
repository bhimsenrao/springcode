package com.onetoone.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.onetoone.entity.Address;
import com.onetoone.entity.Employee;

import com.onetoone.repo.AddressRepository;
import com.onetoone.repo.EmployeeRepository;

@Service
public class EmpAddressService {

    @Autowired
    private EmployeeRepository employeeRepo;

    @Autowired
    private AddressRepository addressRepo;

    @Transactional
    public void addEmployeeAndAddress(Employee employee, Address address) {
        address.setEmployee(employee);
        employee.setAddress(address);
        employeeRepo.save(employee);
    }
    
    public java.util.List<Employee> getEmployeesByCity(String city) { 
    	return employeeRepo.findEmployeesByCity(city);
    }
    
    public Integer countOfEmployeesInCity(String city) {
    	return employeeRepo.findEmployeeByCity(city);
    }
}
