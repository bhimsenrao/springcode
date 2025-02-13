package com.compositekey.controller;

import com.compositekey.entity.Employee;
import com.compositekey.entity.EmployeeIdentity;
import com.compositekey.service.EmployeeService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import java.util.List;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

class EmployeeControllerTest {

    @InjectMocks
    private EmployeeController employeeController;

    @Mock
    private EmployeeService employeeService;

    private MockMvc mockMvc;
    private Employee employee;
    private EmployeeIdentity employeeIdentity;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
        mockMvc = MockMvcBuilders.standaloneSetup(employeeController).build();
        employeeIdentity = new EmployeeIdentity("E123", "C456");
        employee = new Employee(employeeIdentity, "John Doe", "john.doe@example.com", "123-456-7890");
    }

    @Test
    void testCreateEmployee() throws Exception {
        when(employeeService.save(any(Employee.class))).thenReturn(employee);

        mockMvc.perform(post("/api/employees")
                .contentType(MediaType.APPLICATION_JSON)
                .content(new ObjectMapper().writeValueAsString(employee)))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(employeeService, times(1)).save(any(Employee.class));
    }

    @Test
    void testGetById() throws Exception {
        when(employeeService.findById(any(EmployeeIdentity.class))).thenReturn(employee);

        mockMvc.perform(get("/api/employees/E123/C456")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.name").value("John Doe"));

        verify(employeeService, times(1)).findById(any(EmployeeIdentity.class));
    }

    @Test
    void testDeleteById() throws Exception {
        doNothing().when(employeeService).deleteById(any(EmployeeIdentity.class));

        mockMvc.perform(delete("/api/employees/E123/C456")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isNoContent());

        verify(employeeService, times(1)).deleteById(any(EmployeeIdentity.class));
    }

    @Test
    void testGetByCompanyId() throws Exception {
        when(employeeService.findByCompanyId("C456")).thenReturn(List.of(employee));

        mockMvc.perform(get("/api/employees/company/C456")
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$[0].name").value("John Doe"));

        verify(employeeService, times(1)).findByCompanyId("C456");
    }
}
