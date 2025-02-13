package com.compositekey.service;


import com.compositekey.entity.Employee; 
import com.compositekey.entity.EmployeeIdentity; 
import com.compositekey.repo.EmployeeRepository; 
import org.junit.jupiter.api.BeforeEach; 
import org.junit.jupiter.api.Test; 
import org.mockito.InjectMocks; 
import org.mockito.Mock; 
import org.mockito.MockitoAnnotations;

import java.util.List;
import java.util.Optional; 
import static org.junit.jupiter.api.Assertions.*; 
import static org.mockito.Mockito.*; 
class EmployeeServiceTest { 
	@InjectMocks 
	private EmployeeService employeeService; 
	@Mock 
	private EmployeeRepository employeeRepository; 
	
	private Employee employee; 
	private EmployeeIdentity employeeIdentity; 
	
	@BeforeEach void setUp() { 
		MockitoAnnotations.openMocks(this); 
		employeeIdentity = new EmployeeIdentity("E123", "C456"); 
		employee = new Employee(employeeIdentity, "John Doe", "john.doe@example.com", "123-456-7890"); 
		} 
	
	@Test void testSaveEmployee() { 
		when(employeeRepository.save(any(Employee.class))).thenReturn(employee); 
		Employee savedEmployee = employeeService.save(employee); 
		assertNotNull(savedEmployee); assertEquals("John Doe", savedEmployee.getName()); 
		} 
	
	@Test void testFindById() { 
		when(employeeRepository.findById(employeeIdentity)).thenReturn(Optional.of(employee)); 
		Employee foundEmployee = employeeService.findById(employeeIdentity); 
		assertNotNull(foundEmployee); assertEquals("John Doe", foundEmployee.getName()); 
		} 
	
	@Test void testDeleteById() { 
		doNothing().when(employeeRepository).deleteById(employeeIdentity); 
		employeeService.deleteById(employeeIdentity); 
		verify(employeeRepository, times(1)).deleteById(employeeIdentity); } 
	
	@Test void testFindByCompanyId() { 
		when(employeeRepository.findByEmployeeIdentityCompanyId("C456")).thenReturn(List.of(employee)); 
		List<Employee> employees = employeeService.findByCompanyId("C456"); 
		assertNotNull(employees); assertFalse(employees.isEmpty()); assertEquals("John Doe", employees.get(0).getName()); 
		} 
}