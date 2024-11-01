package com.example.springbootdemoultimate.jpademo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.math.BigDecimal;

@Configuration
public class JPADataInitializer {

    //@Bean
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

    @Bean
    CommandLineRunner initProductAndOrderData(ProductRepository productRepository, OrderRepository orderRepository) {
        return args -> {
            // Create Products
            Product product1 = new Product();
            product1.setName("Laptop");
            product1.setPrice(BigDecimal.valueOf(1200.00));

            Product product2 = new Product();
            product2.setName("Smartphone");
            product2.setPrice(BigDecimal.valueOf(800.00));

            // Save products
            productRepository.save(product1);
            productRepository.save(product2);

            // Create Orders and associate them with Products
            Order order1 = new Order();
            order1.setQuantity(1);
            order1.setProduct(product1);

            Order order2 = new Order();
            order2.setQuantity(2);
            order2.setProduct(product2);

            // Save orders
            orderRepository.save(order1);
            orderRepository.save(order2);

            System.out.println("Product and order sample data inserted successfully.");
        };
    }
}

