package org.ssupstart.loginext.fooddelivery.service;

import org.springframework.stereotype.Service;
import org.ssupstart.loginext.fooddelivery.response.OrderResponse;
import org.ssupstart.loginext.fooddelivery.assignmentstrategiesIMP.DefaultAssignmentStrategy;
import org.ssupstart.loginext.fooddelivery.entity.Driver;
import org.ssupstart.loginext.fooddelivery.entity.Order;

import java.util.Optional;

@Service
public class FoodDeliveryService {

    private DefaultAssignmentStrategy defaultAssignmentStrategy;

    public FoodDeliveryService(DefaultAssignmentStrategy defaultAssignmentStrategy) {
        this.defaultAssignmentStrategy = defaultAssignmentStrategy;
    }

    public OrderResponse deliverFood(Order order) {
        Optional<Driver> assignedDriver = defaultAssignmentStrategy.assign(order);
        OrderResponse os = new OrderResponse();
        if(assignedDriver.isPresent()) {
            return os.success(order,assignedDriver.get());
        } else {
            //I am adding default value as -1 if driver is not available
            return os.failure(order,assignedDriver.orElse(new Driver(-1)));
        }
    }
}
