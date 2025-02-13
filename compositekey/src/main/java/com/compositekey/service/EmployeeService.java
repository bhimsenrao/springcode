package com.compositekey.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.compositekey.entity.Employee;
import com.compositekey.entity.EmployeeIdentity;
import com.compositekey.repo.EmployeeRepository;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public Employee save(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee findById(EmployeeIdentity id) {
        return employeeRepository.findById(id).orElse(null);
    }

    public List<Employee> findAll() {
        return employeeRepository.findAll();
    }

    public void deleteById(EmployeeIdentity id) {
        employeeRepository.deleteById(id);
    }
    
    public List<Employee> findByCompanyId(String companyId) {
        return employeeRepository.findByEmployeeIdentityCompanyId(companyId);
    }
}
