package com.example.demo.web.controler.assembler;

import com.example.demo.entity.Order;
import com.example.demo.entity.status.Status;
import com.example.demo.exception.OrderNotFoundException;
import com.example.demo.web.controler.OrderController;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.RepresentationModelAssembler;
import org.springframework.stereotype.Component;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

@Component
public class OrderModelAssembler implements RepresentationModelAssembler<Order, EntityModel<Order>> {
    @Override
    public  EntityModel<Order> toModel(Order order) {
        try {
            EntityModel<Order> orderModel = EntityModel.of(order,
                    linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel(),
                    linkTo(methodOn(OrderController.class).all()).withRel("order"));
            if (order.getStatus() == Status.IN_PROGRESS) {
                orderModel.add(linkTo(methodOn(OrderController.class).cancel(order.getId())).withRel("cancel"));
                orderModel.add(linkTo(methodOn(OrderController.class).complete(order.getId())).withRel("complete"));

            } else {
                orderModel.add(linkTo(methodOn(OrderController.class).one(order.getId())).withSelfRel());
            }
            return orderModel;

        } catch (OrderNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
