package org.ssupstart.loginext.fooddelivery.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Order {
    private int id;
    private int orderTime;
    private int travelTime;

    public Order(int id, int orderTime, int travelTime) {
        this.id = id;
        this.orderTime = orderTime;
        this.travelTime = travelTime;
    }
}
