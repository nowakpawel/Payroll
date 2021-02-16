package com.example.demo.entity;

import com.example.demo.entity.status.Status;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "CUSTOMER_ORDER")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descriprion;
    private Status status;

    Order() {}

    public Order(String descriprion, Status status) {
        this.descriprion = descriprion;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescriprion() {
        return descriprion;
    }

    public void setDescriprion(String descriprion) {
        this.descriprion = descriprion;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Order))
            return false;
        Order order = (Order) o;
        return Objects.equals(this.id, order.id) && Objects.equals(this.descriprion, order.descriprion)
                && this.status == order.status;
    }

    @Override
    public int hashCode() {
       return Objects.hash(this.id, this.descriprion, this.descriprion);
    }

    @Override
    public String toString() {
        return "Order [ " +
                "id=" + id +
                ", descriprion='" + descriprion + '\'' +
                ", status=" + status +
                " ]";
    }
}
