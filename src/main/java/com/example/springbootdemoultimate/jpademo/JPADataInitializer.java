package com.example.springbootdemoultimate.jpademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class JPADataInitializer {

    @Bean
    CommandLineRunner initData(DepartmentRepository departmentRepository, EmployeeRepository employeeRepository) {
        return args -> {
            // Create a Department
            Department department = new Department();
            department.setName("Engineering");

            // Create Employees and associate them with the Department
            Employee employee1 = new Employee();
            employee1.setName("Alice");
            employee1.setDepartment(department);

            Employee employee2 = new Employee();
            employee2.setName("Bob");
            employee2.setDepartment(department);

            // Add employees to the department
            department.getEmployees().add(employee1);
            department.getEmployees().add(employee2);

            // Save the department, which will also save the employees due to CascadeType.ALL
            departmentRepository.save(department);

            System.out.println("Sample data inserted successfully.");
        };
    }
}

