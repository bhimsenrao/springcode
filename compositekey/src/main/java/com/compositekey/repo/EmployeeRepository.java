package com.compositekey.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.compositekey.entity.Employee;
import com.compositekey.entity.EmployeeIdentity;

public interface EmployeeRepository extends JpaRepository<Employee, EmployeeIdentity> {

	  java.util.List<Employee> findByEmployeeIdentityCompanyId(String companyId);
}
