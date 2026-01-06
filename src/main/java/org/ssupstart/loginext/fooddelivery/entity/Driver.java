package org.ssupstart.loginext.fooddelivery.entity;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class Driver {
    //This classes we can convert to entity for database related implementation
    //I am currently using in memory queue only so not adding entity related annotation
    private int id;
    private int freeTime;

    public Driver(int id) {
        this.id = id;
        this.freeTime = 0;
    }

    public boolean isAvailable(int orderTime) {
        return this.freeTime <= orderTime;
    }

    public void assign(Order order) {
        this.freeTime = order.getOrderTime() + order.getTravelTime();
    }
}
