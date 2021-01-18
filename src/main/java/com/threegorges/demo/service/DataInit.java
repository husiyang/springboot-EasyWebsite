package com.threegorges.demo.service;

import com.threegorges.demo.domain.Employee;
import com.threegorges.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

@Service
public class DataInit {

    @Autowired private EmployeeRepository employeeRepository;

    @PostConstruct
    public void dataInit(){
        Employee admin = new Employee("admin");
        admin.setRole(Employee.Role.admin);
        employeeRepository.save(admin);

        Employee user = new Employee("user");
        admin.setRole(Employee.Role.normal);
        employeeRepository.save(user);
    }
}
