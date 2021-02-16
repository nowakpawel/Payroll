package com.example.demo.web.controler.assembler;

import com.example.demo.exception.EmployeeNotFoundException;
import com.example.demo.entity.Employee;
import com.example.demo.web.controler.EmployeeController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class EmployeeModelAssembler implements RepresentationModelAssembler<Employee, EntityModel<Employee>> {
    @Override
    public EntityModel<Employee> toModel(Employee employee) {
        try {
            return EntityModel.of(employee,
                    WebMvcLinkBuilder.linkTo(methodOn(EmployeeController.class).one(employee.getId())).withSelfRel(),
                    linkTo(methodOn(EmployeeController.class).all()).withRel("employees"));
        } catch (EmployeeNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
