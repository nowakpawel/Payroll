package com.example.demo;

import com.example.demo.entity.Order;
import com.example.demo.entity.status.Status;
import com.example.demo.repository.EmployeeRepository;
import com.example.demo.entity.Employee;
import com.example.demo.repository.OrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger logger = LoggerFactory.getLogger(LoadDatabase.class);

    @Bean
    CommandLineRunner initDatabase(EmployeeRepository employeeRepository, OrderRepository orderRepository) {
        return args -> {
            employeeRepository.save(new Employee("Paweł", "Nowak", "Java Developer"));
            employeeRepository.save(new Employee("Paweł", "Nowak", "Test Enginner"));
            employeeRepository.save(new Employee("Natalia", "Cichocka", "UX Designer"));

            employeeRepository.findAll().forEach(employee -> logger.info("Preloaded: " + employee));

            orderRepository.save(new Order("MacBook Pro", Status.COMPLETED));
            orderRepository.save(new Order("iPhone XR", Status.IN_PROGRESS));

            orderRepository.findAll().forEach(order -> logger.info("Preloaded: " + order));
        };
    }
}
