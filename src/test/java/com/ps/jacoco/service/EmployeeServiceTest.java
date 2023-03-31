package com.ps.jacoco.service;

import com.ps.jacoco.model.Employee;
import com.ps.jacoco.repository.EmployeeRepository;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
public class EmployeeServiceTest {

    @InjectMocks
    public EmployeeService employeeService;

    @Mock
    private EmployeeRepository employeeRepository;

    @Test
    public void getAllEmployeeTest()
    {
        Mockito.when(employeeRepository.findAll()).thenReturn(getEmployees());
        Employee employee=Employee.builder().id(1).firstName("Pranay").lastName("Dutta").email("pranaykumar@gmail.com").build();
        List<Employee> employees= employeeService.getAllEmployee();
        Assertions.assertEquals(1,employees.size());
    }


    @Test
public void createEmployeeTest()
{
    Employee employee=Employee.builder().id(1).firstName("Pranay").lastName("Dutta").build();
    Mockito.when(employeeService.createEmployee(employee)).thenReturn(employee);
    Employee employee1=employeeService.createEmployee(employee);
    Assertions.assertEquals("Pranay",employee1.getFirstName());
}

@Test
    public void findEmployeeByIdTest()
    {
        Employee employee=Employee.builder().id(1L).firstName("Pranay").lastName("Dutta").build();
        Mockito.when(employeeService.findEmployeeById(1L)).thenReturn(Optional.ofNullable(employee));
        Optional<Employee> employee1=employeeService.findEmployeeById(1L);
        Assertions.assertEquals("Pranay",employee1.get().getFirstName());
    }



 public List<Employee> getEmployees()
    {
        List<Employee> employees=new ArrayList<>();
            Employee employee=Employee.builder().id(1).firstName("Pranay").lastName("Dutta").email("PranayKumar@Gmail.com").build();
            employees.add(employee);
        return employees;

    }
}
