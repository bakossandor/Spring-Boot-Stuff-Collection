package com.example.orders.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

enum OrderStatus {
    UNDER_PROCESS,
    UNDER_DELIVERY,
    COMPLETED,
}

@Getter
@Setter
@Entity(name = "orders")
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "order_date")
    private Date order_date;

    @Column(name = "order_status")
    private OrderStatus orderStatus;

    @Column(name = "order_total_price")
    private Double order_total_price;

    public Order() {
    }
}
